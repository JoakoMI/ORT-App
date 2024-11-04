package com.joako.ort_app.screens.miCuenta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import com.joako.ort_app.components.ActionButtonsRow
import com.joako.ort_app.components.MovimientoItem
import com.joako.ort_app.ui.theme.manrope

@Composable
fun MiCuentaScreen(viewModel: MiCuentaScreenViewModel = viewModel(), modifier: Modifier = Modifier) {
    viewModel.fetchWallet()
    val wallet = viewModel.wallet.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F3F3)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mi Cuenta",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))

        val saldoDisponible = wallet.value?.get(0)?.balance ?: "N/A"
        val cvu = wallet.value?.get(0)?.bank_account?.cvu ?: "N/A"
        val creditTCardTransactions =
            wallet.value?.get(0)?.transactions?.credit_card_transactions ?: emptyList()
        val bankAccountTransactions =
            wallet.value?.get(0)?.transactions?.bank_account_transactions ?: emptyList()
        val transactions = creditTCardTransactions + bankAccountTransactions

        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier.padding(12.dp)
                .fillMaxWidth()
                .border(
                    border = BorderStroke(1.dp, Color(0xFFD1D1D7)),
                    shape = RoundedCornerShape(8.dp)
                ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "SALDO DISPONIBLE",
                    fontSize = 12.sp,
                    color = Color(0xFF2A1846),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = saldoDisponible,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2A1846)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    thickness = 1.dp,
                    color = Color(0xFFD1D1D7)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "CVU: ",
                        fontSize = 14.sp,
                        color = Color(0xFF2A1846)
                    )
                    Text(
                        text = cvu,
                        fontSize = 14.sp,
                        color = Color(0xFF2A1846),
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(onClick = { }) {
                        Text(
                            "Copiar",
                            fontWeight = FontWeight.Bold,
                            fontFamily = manrope,
                            color = Color(0xFF442E83)
                        )
                    }
                }
            }
        }

        ActionButtonsRow()
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .background(Color(0xFF300656)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "MOVIMIENTOS",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        LazyColumn {
            items(transactions.size) { transaction ->
                MovimientoItem(transactions[transaction])
                HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}



//@Composable
//fun MiCuentaScreen(modifier: Modifier = Modifier) {
//    val viewModel: MiCuentaScreenViewModel = viewModel(
//        factory = MiCuentaScreenViewModel.provideFactory()
//    )
//
//
//    viewModel.fetchWallet()
//    val wallet = viewModel.wallet.observeAsState()
//
//
//    Column(modifier = modifier.padding(16.dp)) {
//        Text("UserId: " + wallet.value?.get(0)?.user_id)
//        Text("Balance: " + wallet.value?.get(0)?.balance)
//        Text("Bank: " + (wallet.value?.get(0)?.bank_account?.bank_name))
//        Text("Type: " + (wallet.value?.get(0)?.bank_account?.account_type))
//        Text("Alias: " + (wallet.value?.get(0)?.bank_account?.alias))
//        Text("CVU: " + (wallet.value?.get(0)?.bank_account?.cvu))
//        Text("Currency: " + (wallet.value?.get(0)?.bank_account?.currency))
//
//        Spacer(modifier = Modifier.padding(16.dp))
//
////        Text("Bank transactions:")
////        wallet.value?.get(0)?.transactions?.bank_account_transactions?.forEach { transaction ->
////            Text("Amount: " + transaction.amount)
////            Text("Date: " + transaction.date)
////            Text("Description: " + transaction.description)
////            Text("Type: " + transaction.type)
////        }
//        Text("Credit Card transactions:")
//
//        wallet.value?.get(0)?.transactions?.credit_card_transactions?.forEach { transaction ->
//            Text("Amount: " + transaction.amount)
//            Text("Date: " + transaction.date)
//            Text("Description: " + transaction.description)
//            Text("Type: " + transaction.type)
//        }
//        }
//    }


