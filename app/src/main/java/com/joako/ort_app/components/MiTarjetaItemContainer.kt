package com.joako.ort_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R

@Composable
fun MiTarjetaItemContainer(modifier: Modifier = Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .background(Color.White),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Column() {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Quiero mi tarjeta física", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.btn),
                    contentDescription = "Arrow btn",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    tint = Color.Unspecified

                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.gray_500)
            )
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "Ya tengo mi tarjeta física", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                    )
                    Text(
                        "Activa tu tarjeta para comenzar a usarla", style = TextStyle(
                            fontSize = 14.sp, color = colorResource(id = R.color.black)
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.btn),
                    contentDescription = "Arrow btn",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    tint = Color.Unspecified

                )
            }
        }
    }
}

