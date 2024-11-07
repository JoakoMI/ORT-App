package com.joako.ort_app.screens.miCuenta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.joako.ort_app.R
import com.joako.ort_app.components.MiCuentaButtonRow
import com.joako.ort_app.components.MiCuentaMovimientos
import com.joako.ort_app.components.MiCuentaSaldoCard
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun MiCuentaScreen(
    modifier: Modifier = Modifier,
    navigationActions: MainNavActions,
    viewModel: MiCuentaScreenViewModel
) {    viewModel.fetchWallet()
    val wallet = viewModel.wallet.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val saldoDisponible = wallet.value?.get(0)?.balance ?: "N/A"
        val cvu = wallet.value?.get(0)?.bank_account?.cvu ?: "N/A"
        val creditTCardTransactions =
            wallet.value?.get(0)?.transactions?.credit_card_transactions ?: emptyList()
        val bankAccountTransactions =
            wallet.value?.get(0)?.transactions?.bank_account_transactions ?: emptyList()
        val transactions = creditTCardTransactions + bankAccountTransactions

        MiCuentaSaldoCard(saldoDisponible = saldoDisponible, cvu = cvu)


        Spacer(modifier = Modifier.height(12.dp))

        MiCuentaButtonRow(
            modifier = Modifier.fillMaxWidth(),
            navigationActions = navigationActions
        )

        Spacer(modifier = Modifier.height(24.dp))

        MiCuentaMovimientos(transactions = transactions)

    }
}



