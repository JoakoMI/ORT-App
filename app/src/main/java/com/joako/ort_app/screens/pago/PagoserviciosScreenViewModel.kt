package com.joako.ort_app.screens.pago

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joako.ort_app.R
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.navigation.MainNavActions

data class Option(val iconResId: Int, val title: String, val id: Int)

class PagoServiciosScreenViewModel(private val retrofitInstance: RetroFitInstance) : ViewModel() {
    val options = listOf(
        Option(R.drawable.recargasube, "RECARGA SUBE", 1),
        Option(R.drawable.recarga_celu2, "RECARGA CELULAR", 2),
        Option(R.drawable.pagoservicio, "PAGO DE SERVICIOS", 3),
        Option(R.drawable.directtv, "DIRECT TV PREPAGO", 4)
    )

    fun getNavigationAction(optionId: Int, navigationActions: MainNavActions): () -> Unit {
        return when (optionId) {
            1 -> { { navigationActions.navigateToRecargaSube() } }
            else -> { {} }
        }
    }

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