package com.joako.ort_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.ui.theme.manrope

@Composable
fun MiCuentaSaldoCard(modifier: Modifier = Modifier, saldoDisponible: String, cvu: String) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, Color(0xFFD1D1D7)),
                shape = RoundedCornerShape(8.dp)
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))

    ) {
        Column(
            modifier = Modifier.padding(12.dp),
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
}