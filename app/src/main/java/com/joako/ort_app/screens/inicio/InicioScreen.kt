package com.joako.ort_app.screens.inicio

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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import com.joako.ort_app.components.ActionButton
import com.joako.ort_app.components.ActionButtonsRow
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun InicioScreen(
    modifier: Modifier = Modifier,
    navigationActions: MainNavActions,
    viewModel: InicioScreenViewModel,
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
                        fontSize = 18.sp, fontWeight = FontWeight.Bold
                    ), text = "\uD83D\uDC4B Hola Mariana"
                )
                Text(
                    style = TextStyle(
                        fontSize = 12.sp,
                    ), text = "Ultimo acceso: Mar 01, 2020 4:55 PM"
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

            Row {
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

            Card(modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {

                Row {
                    Column(modifier.padding(vertical = 10.dp, horizontal = 16.dp)) {
                        Text(
                            style = TextStyle(
                                fontSize = 12.sp
                            ), text = "La cuota de tu préstamo está próxima a vencer."
                        )

                        Text(
                            style = TextStyle(
                                fontSize = 12.sp, fontWeight = FontWeight.Bold
                            ), text = "Ver préstamo"
                        )
                    }
                    Icon(
                        painter = painterResource(R.drawable.arrow_next),
                        contentDescription = "Ver préstamo",
                        tint = colorResource(id = R.color.white),

                        )

                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))


        ActionButtonsRow(modifier.fillMaxWidth())
        ActionButtonsRow(modifier.fillMaxWidth())
    }
}



