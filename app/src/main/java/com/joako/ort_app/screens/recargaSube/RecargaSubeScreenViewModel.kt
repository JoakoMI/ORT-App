package com.joako.ort_app.screens.recargaSube

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.navigation.MainNavActions

class RecargaSubeScreenViewModel(private val retrofitInstance: RetroFitInstance) : ViewModel() {

    private val _amount = MutableLiveData("200,00")
    val amount: MutableLiveData<String> = _amount

    private val _cardNumber = MutableLiveData("6061 3580 2384 9041")
    val cardNumber: LiveData<String> = _cardNumber

    fun getNavigationAction(navigationActions: MainNavActions): () -> Unit {
        return { navigationActions.navigateToConfirmacionSube() }
    }

    companion object {
        fun provideFactory(retrofitInstance: RetroFitInstance): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(RecargaSubeScreenViewModel::class.java)) {
                        return RecargaSubeScreenViewModel(retrofitInstance) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
    }
}