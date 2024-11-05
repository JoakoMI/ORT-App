package com.joako.ort_app.screens.miTarjeta

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun MiTarjetaScreen(
    modifier: Modifier = Modifier,
    navigationActions: MainNavActions,
    viewModel: MiTarjetaScreenViewModel,
) {

    Column(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background)),
    ) {
        Row(modifier = modifier.padding(vertical = 24.dp, horizontal = 12.dp)) {
            Column {
                Text(
                    style = TextStyle(
                        fontSize = 12.sp, fontWeight = FontWeight.Bold
                    ), text = "TARJETA VIRTUAL"
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(id = R.drawable.tarjeta_img),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(336.dp)
                    .height(212.dp)
            )


            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.visibility),
                    contentDescription = "Tarjeta",
                    tint = colorResource(id = R.color.purple_900),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.purple_900)
                    ), text = " Mostrar datos"
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                color = colorResource(id = R.color.gray_500)
            )

            Text(
                "\uD83D\uDCA1 ¿Sabías que poder pedir una tarjeta Mastercard física para utilizar directamente en los negocios que vos elijas?",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 20.sp,

                    )
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            style = TextStyle(
                fontSize = 12.sp, fontWeight = FontWeight.Bold
            ), text = "TARJETA FISICA"
        )
        Spacer(modifier = Modifier.height(16.dp))

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

}

@Preview(showBackground = true)
@Composable
private fun MiTarjetaPrev() {

}
