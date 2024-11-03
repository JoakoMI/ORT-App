package com.joako.ort_app.screens.miCuenta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.firebase.firestore.FirebaseFirestore
import com.joako.ort_app.data.Wallet

class MiCuentaScreenViewModel : ViewModel() {

    private val _wallet = MutableLiveData<List<com.joako.ort_app.data.Wallet>>()
    val wallet : LiveData<List<com.joako.ort_app.data.Wallet>> = _wallet

    private val fireStore = FirebaseFirestore.getInstance()
    private val walletCollection = fireStore.collection("wallet")


    fun fetchWallet() {
        walletCollection.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val walletList = ArrayList<com.joako.ort_app.data.Wallet>()
                for (item in task.result) {
                    val wallets = item.toObject(com.joako.ort_app.data.Wallet::class.java)
                    walletList.add(wallets)
                }

                if (walletList.isNotEmpty()) {
                    _wallet.value = walletList
                }
            }
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MiCuentaScreenViewModel() as T
            }
        }
    }
}