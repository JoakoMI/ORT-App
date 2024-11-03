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

@Composable
fun MiCuentaScreen(modifier: Modifier = Modifier) {
    val viewModel: MiCuentaScreenViewModel = viewModel(
        factory = MiCuentaScreenViewModel.provideFactory()
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


        Text("Banktransactions:")
        wallet.value?.get(0)?.transactions?.BankAccountransactionList?.forEachIndexed() { index, element ->

            Text("Transaction: " + index.toString())
            Text("Amount: " + element.amount.toString())
            Text("Date: " + element.date.toString())
            Text("Description: " + element.description.toString())
            Text("Type: " + element.type.toString())
        }


    }
}

