package com.joako.ort_app.components.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.R
import com.joako.ort_app.navigation.MainNavActions
import com.joako.ort_app.navigation.Routes


@Composable
fun BottomBar(
    navActions: MainNavActions,
    viewModel: MainActivityViewModel,
) {
    val currentRoute = viewModel.getRoute()

    BottomAppBar(
        modifier = Modifier.padding(0.dp),
        containerColor = Color.White,
    ) {
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "Home",
                    tint = if (currentRoute == Routes.INICIO_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900)
                )
            },
            onClick = navActions.navigateToInicio,
            selected = currentRoute == Routes.INICIO_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.movimientos),
                    contentDescription = "Mi Cuenta",
                    tint = if (currentRoute == Routes.MICUENTA_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900)
                )
            },
            onClick = navActions.navigateMiCuenta,
            selected = currentRoute == Routes.MICUENTA_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.tarjeta_credito),
                    contentDescription = "Tarjeta",
                    tint = if (currentRoute == Routes.MITARJETA_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900)
                )
            },
            onClick = navActions.navigateMiTarjeta,
            selected = currentRoute == Routes.MITARJETA_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.wallet),
                    contentDescription = "Pagos",
                    tint = if (currentRoute == Routes.PAGOSERVICIOS_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900)
                )
            },
            onClick = navActions.navigateToPago,
            selected = currentRoute == Routes.PAGOSERVICIOS_SCREEN,
        )
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu",
                    tint = Color.Gray
                )
            },
            onClick = { viewModel.openDrawer() },
            selected = false,
        )
    }
}




@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val viewModel: MainActivityViewModel = viewModel(factory = MainActivityViewModel.Factory)
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState)
    }

    BottomBar(
        navActions = navigationActions,
        viewModel = viewModel
    )
}

