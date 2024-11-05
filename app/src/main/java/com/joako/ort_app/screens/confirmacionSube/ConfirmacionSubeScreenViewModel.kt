package com.joako.ort_app.screens.confirmacionSube

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.navigation.MainNavActions

class ConfirmacionSubeScreenViewModel(private val retrofitInstance: RetroFitInstance) : ViewModel() {

    fun getNavigationAction(navigationActions: MainNavActions): () -> Unit {
        return { navigationActions.navigateToInicio() }
    }
    companion object {
        fun provideFactory(retrofitInstance: RetroFitInstance): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(ConfirmacionSubeScreenViewModel::class.java)) {
                        return ConfirmacionSubeScreenViewModel(retrofitInstance) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
    }
}