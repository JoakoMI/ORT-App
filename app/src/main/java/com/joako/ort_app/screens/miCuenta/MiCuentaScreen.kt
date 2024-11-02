package com.joako.ort_app.screens.miCuenta

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joako.ort_app.MainActivityViewModel

@Composable
fun MiCuentaScreen(modifier: Modifier = Modifier, viewModel: MainActivityViewModel) {
    val viewModel: MiCuentaScreenViewModel = viewModel(
        factory = MiCuentaScreenViewModel.provideFactory()
    )
    val wallet = viewModel.getWallet()

    Column {
    Text(wallet.toString())
    }
}