package com.joako.ort_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R

@Composable
fun RecargaSubeCard(modifier: Modifier = Modifier, cardNumber: String, amount: String) {
    Card(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.sube_logo),
                contentDescription = null
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                thickness = 1.dp,
                color = Color(0xFFD1D1D7)
            )

            Row {
                Text(
                    text = "Tarjeta No: ",
                    fontSize = 14.sp,
                    color = Color(0xFF2A1846)
                )
                Text(
                    text = cardNumber,
                    fontSize = 16.sp,
                    color = Color(0xFF2A1846)
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                thickness = 1.dp,
                color = Color(0xFFD1D1D7)
            )

            Text(
                text = "$$amount",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2A1846)
            )
        }
    }
}