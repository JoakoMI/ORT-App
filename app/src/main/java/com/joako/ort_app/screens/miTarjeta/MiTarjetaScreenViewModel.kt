package com.joako.ort_app.screens.miTarjeta

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joako.ort_app.data.retrofit.RetroFitInstance

class MiTarjetaScreenViewModel(private val retrofitInstance: RetroFitInstance) : ViewModel() {


    companion object {
        fun provideFactory(retrofitInstance: RetroFitInstance): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(MiTarjetaScreenViewModel::class.java)) {
                        return MiTarjetaScreenViewModel(retrofitInstance) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
    }
}