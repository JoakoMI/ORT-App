package com.joako.ort_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InicioSaldoView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = TextStyle(
                fontSize = 12.sp, fontWeight = FontWeight.Bold
            ), text = "SALDO DISPONIBLE"
        )
        Text(

            style = TextStyle(
                fontWeight = FontWeight.Black, fontSize = 44.sp
            ), text = "$ 1.322,78"
        )
    }
}