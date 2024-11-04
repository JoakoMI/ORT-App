package com.joako.ort_app.screens.miCuenta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.joako.ort_app.data.firestore.Wallet
import com.joako.ort_app.data.retrofit.RetroFitInstance

class MiCuentaScreenViewModel(retrofitInstance: RetroFitInstance) : ViewModel() {

    private val _wallet = MutableLiveData<List<Wallet>>()
    val wallet : LiveData<List<Wallet>> = _wallet

    private val fireStore = FirebaseFirestore.getInstance()
    private val walletCollection = fireStore.collection("wallet")


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
                }
            }
        }
    }

    companion object {
        fun provideFactory(retrofitInstance: RetroFitInstance): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(MiCuentaScreenViewModel::class.java)) {
                        return MiCuentaScreenViewModel(retrofitInstance) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
    }
}