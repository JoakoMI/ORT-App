
package com.joako.ort_app.screens.miTarjeta

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.components.CardMock
import com.joako.ort_app.components.MiTarjetaItemContainer
import com.joako.ort_app.components.VisibilityOption
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
            CardMock()

            Spacer(modifier = Modifier.height(8.dp))

            VisibilityOption()

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

        MiTarjetaItemContainer()


    }

}

@Preview(showBackground = true)
@Composable
private fun MiTarjetaPrev() {

}
