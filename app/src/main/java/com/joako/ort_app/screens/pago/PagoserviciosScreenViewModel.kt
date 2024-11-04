package com.joako.ort_app.screens.pago

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joako.ort_app.data.retrofit.RetroFitInstance

class PagoServiciosScreenViewModel(retrofitInstance: RetroFitInstance) : ViewModel() {


    companion object {
        fun provideFactory(retrofitInstance: RetroFitInstance): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(PagoServiciosScreenViewModel::class.java)) {
                        return PagoServiciosScreenViewModel(retrofitInstance) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
    }
}