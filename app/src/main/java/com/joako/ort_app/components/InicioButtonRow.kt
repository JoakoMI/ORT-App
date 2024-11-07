package com.joako.ort_app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joako.ort_app.R
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun InicioButtonRow(modifier: Modifier = Modifier, navigationActions: MainNavActions) {
    Card(modifier
        .fillMaxWidth()
        .padding(12.dp), shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionButton(
                modifier = Modifier.weight(1f),
                iconResId = R.drawable.recarga_sube,
                label1 = "RECARGA",
                label2 = "SUBE",
                onClick = {navigationActions.navigateToRecargaSube()}
            )
            VerticalDivider(
                color = Color.LightGray,
                modifier = Modifier
                    .height(96.dp)
                    .width(5.dp)
            )

            ActionButton(
                modifier = Modifier.weight(1f),
                iconResId = R.drawable.recarga_celu,
                label1 = "RECARGA",
                label2 = "CALULAR",
                onClick = {  }
            )

            VerticalDivider(
                color = Color.LightGray,
                modifier = Modifier
                    .height(96.dp)
                    .width(1.dp)
            )

            ActionButton(
                modifier = Modifier.weight(1f),
                iconResId = R.drawable.pagoservicio,
                label1 = "PAGAR",
                label2 = "SERVICIO",
                onClick = { }
            )
        }
        HorizontalDivider(
            color = Color.LightGray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionButton(
                modifier = Modifier.weight(1f),
                iconResId = R.drawable.cargar_dinero,
                label1 = "CARGAR",
                label2 = "DINERO",
                onClick = { }
            )
            VerticalDivider(
                color = Color.LightGray,
                modifier = Modifier
                    .height(96.dp)
                    .width(5.dp)
            )

            ActionButton(
                modifier = Modifier.weight(1f),
                iconResId = R.drawable.extraer_dinero,
                label1 = "EXTRAER",
                label2 = "DINERO",
                onClick = {  }
            )

            VerticalDivider(
                color = Color.LightGray,
                modifier = Modifier
                    .height(96.dp)
                    .width(1.dp)
            )

            ActionButton(
                modifier = Modifier.weight(1f),
                iconResId = R.drawable.transferir_dinero,
                label1 = "TRANSFERIR",
                label2 = "DINERO",
                onClick = {  }
            )
        }
    }
}