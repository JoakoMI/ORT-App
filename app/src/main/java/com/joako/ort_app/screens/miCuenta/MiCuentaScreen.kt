package com.joako.ort_app.screens.miCuenta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun MiCuentaScreen(
    modifier: Modifier = Modifier,
    navigationActions: MainNavActions,
    viewModel: MiCuentaScreenViewModel
) {
    val viewModel: MiCuentaScreenViewModel = viewModel(
        factory = MiCuentaScreenViewModel.provideFactory(
            retrofitInstance = RetroFitInstance
        )
    )

    LaunchedEffect(Unit) {
        delay(3000)
        viewModel.fetchWallet()
    }

    val wallet = viewModel.wallet.observeAsState()

    Column(modifier = modifier.padding(16.dp)) {
        Text("UserId: " + wallet.value?.get(0)?.user_id.toString())
        Text("Balance: " + wallet.value?.get(0)?.balance.toString())
        Text("Bank: " + (wallet.value?.get(0)?.bank_account?.bank_name.toString()))
        Text("Type: " + (wallet.value?.get(0)?.bank_account?.account_type.toString()))
        Text("Alias: " + (wallet.value?.get(0)?.bank_account?.alias.toString()))
        Text("CVU: " + (wallet.value?.get(0)?.bank_account?.cvu.toString()))
        Text("Currency: " + (wallet.value?.get(0)?.bank_account?.currency.toString()))




    }
}

