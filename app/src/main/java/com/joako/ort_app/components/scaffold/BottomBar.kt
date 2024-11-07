package com.joako.ort_app.components.scaffold

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
    val currentRoute = viewModel.getRoute()
    Log.d("BottomBar", "Current Route: $currentRoute")

    BottomAppBar(
        containerColor = Color.White,
        modifier = Modifier.padding(0.dp)
    ) {
        NavigationBarItem(
            icon = {
                Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxHeight()) {
                    if (currentRoute == Routes.INICIO_SCREEN) {
                        Icon(
                            painter = painterResource(R.drawable.green_line),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .height(2.dp)
                                .width(64.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(
                            if (currentRoute == Routes.INICIO_SCREEN) R.drawable.home_green else R.drawable.home
                        ),
                        contentDescription = "Home",
                        tint = Color.Unspecified,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            onClick = navActions.navigateToInicio,
            selected = currentRoute == Routes.INICIO_SCREEN,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                unselectedIconColor = Color.Unspecified,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxHeight()) {
                    if (currentRoute == Routes.MICUENTA_SCREEN) {
                        Icon(
                            painter = painterResource(R.drawable.green_line),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .height(2.dp)
                                .width(64.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(R.drawable.movimientos),
                        contentDescription = "Mi Cuenta",
                        tint = if (currentRoute == Routes.MICUENTA_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            onClick = navActions.navigateMiCuenta,
            selected = currentRoute == Routes.MICUENTA_SCREEN,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                unselectedIconColor = Color.Unspecified,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxHeight()) {
                    if (currentRoute == Routes.MITARJETA_SCREEN) {
                        Icon(
                            painter = painterResource(R.drawable.green_line),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .height(2.dp)
                                .width(64.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(R.drawable.tarjeta_credito),
                        contentDescription = "Tarjeta",
                        tint = if (currentRoute == Routes.MITARJETA_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            onClick = navActions.navigateMiTarjeta,
            selected = currentRoute == Routes.MITARJETA_SCREEN,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                unselectedIconColor = Color.Unspecified,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxHeight()) {
                    if (currentRoute == Routes.PAGOSERVICIOS_SCREEN) {
                        Icon(
                            painter = painterResource(R.drawable.green_line),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .height(2.dp)
                                .width(64.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(R.drawable.wallet),
                        contentDescription = "Pagos",
                        tint = if (currentRoute == Routes.PAGOSERVICIOS_SCREEN) colorResource(R.color.green_800) else colorResource(R.color.purple_900),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            onClick = navActions.navigateToPago,
            selected = currentRoute == Routes.PAGOSERVICIOS_SCREEN,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                unselectedIconColor = Color.Unspecified,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()) {
                    Icon(
                        painter = painterResource(R.drawable.menu),
                        contentDescription = "Menu",
                        tint = Color.Gray
                    )
                }
            },
            onClick = { viewModel.openDrawer() },
            selected = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                unselectedIconColor = Color.Unspecified,
                indicatorColor = Color.Transparent
            )
        )
    }
}