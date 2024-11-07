package com.joako.ort_app.screens.inicio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.joako.ort_app.components.capitalizeFirstLetter
import com.joako.ort_app.data.firestore.Wallet
import com.joako.ort_app.data.retrofit.RetroFitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InicioScreenViewModel(private val retrofitInstance: RetroFitInstance) : ViewModel() {
    private val userApi = retrofitInstance.api

    private val _wallet = MutableLiveData<List<Wallet>>()
    val wallet: LiveData<List<Wallet>> = _wallet

    private val fireStore = FirebaseFirestore.getInstance()
    private val walletCollection = fireStore.collection("wallet")

    private val _saldoDisponible = MutableLiveData<String>()
    val saldoDisponible: LiveData<String> = _saldoDisponible

    fun fetchWallet() {
        walletCollection.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val walletList = ArrayList<Wallet>()
                for (item in task.result) {
                    val wallets = item.toObject(Wallet::class.java)
                    walletList.add(wallets)
                }

                if (walletList.isNotEmpty()) {
                    _wallet.value = walletList
                    _saldoDisponible.value = walletList[0].balance ?: "N/A"
                }
            }
        }
    }

    private val _firstName = MutableStateFlow("")
    val firstName: StateFlow<String> get() = _firstName

    private val _lastName = MutableStateFlow("")
    val lastName: StateFlow<String> get() = _lastName

    init {
        fetchWallet()
        fetchUserName()
    }

    private fun fetchUserName() {
        viewModelScope.launch {
            try {
                val response = userApi.getUser(7)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _firstName.value = it.name.firstname.capitalizeFirstLetter()
                        _lastName.value = it.name.lastname.capitalizeFirstLetter()
                    }
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    companion object {
        fun provideFactory(retrofitInstance: RetroFitInstance): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(InicioScreenViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return InicioScreenViewModel(retrofitInstance) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }
}