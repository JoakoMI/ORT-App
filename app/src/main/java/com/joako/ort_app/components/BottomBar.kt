package com.joako.ort_app.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.R
import com.joako.ort_app.navigation.MainNavActions
import com.joako.ort_app.navigation.Routes


@Composable
fun BottomBar(
    navActions: MainNavActions,
    viewModel: MainActivityViewModel,
) {


    val space = 20.dp

    BottomAppBar (
        modifier = Modifier.padding(0.dp),
        containerColor = Color.White,
    ) {

        NavigationBarItem(
            modifier = Modifier.weight(1f),

            icon = {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "Home",
                )
            },
            onClick = navActions.navigateToInicio,
            selected = viewModel.getRoute() == Routes.INICIO_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.movimientos),
                    contentDescription = "micuenta"
                )
            },
            onClick = navActions.navigateMiCuenta,
            selected = viewModel.getRoute() == Routes.MICUENTA_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.tarjeta_credito),
                    contentDescription = "tarjeta"
                )
            },
            onClick = navActions.navigateMiTarjeta,
            selected = viewModel.getRoute() == Routes.MITARJETA_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.wallet),
                    contentDescription = "pagos"
                )
            },
            onClick = navActions.navigateToPago,
            selected = viewModel.getRoute() == Routes.PAGOSERVICIOS_SCREEN,
        )

        NavigationBarItem(
            modifier = Modifier.weight(1f),

            icon = {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Home"
                )
            },
            onClick = navActions.navigateToInicio,
            selected = viewModel.getRoute() == Routes.INICIO_SCREEN,
        )

    }
}
