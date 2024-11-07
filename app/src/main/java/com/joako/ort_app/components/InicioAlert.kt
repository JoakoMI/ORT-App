package com.joako.ort_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R

@Composable
fun InicioAlert(modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(12.dp), shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            modifier.background(colorResource(id = R.color.box_notifier)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier.padding(horizontal = 16.dp)) {
                Text(
                    style = TextStyle(
                        fontSize = 12.sp
                    ),
                    text = "La cuota de tu préstamo está próxima a vencer.",
                    color = colorResource(id = R.color.white)
                )

                Text(
                    style = TextStyle(
                        fontSize = 12.sp, fontWeight = FontWeight.Bold
                    ),
                    text = "Ver préstamo",
                    color = colorResource(id = R.color.white)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.arrow_next),
                contentDescription = "Ver préstamo",
                tint = colorResource(id = R.color.white),
                modifier = Modifier.padding(24.dp)

            )

        }
    }
}