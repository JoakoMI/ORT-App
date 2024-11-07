package com.joako.ort_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.data.firestore.Transaction

@Composable
fun MiCuentaMovimientos(modifier: Modifier = Modifier, transactions: List<Transaction>) {
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
            HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
        }
    }
}