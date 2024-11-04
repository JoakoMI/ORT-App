package com.joako.ort_app.navigation

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainNavActions(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    val navigateToInicio: () -> Unit = {
        navController.navigate(Routes.INICIO_SCREEN) {
            scope.launch {
                drawerState.close()
            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateMiCuenta: () -> Unit = {
        navController.navigate(Routes.MICUENTA_SCREEN) {
            scope.launch {
                drawerState.close()
            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateMiTarjeta: () -> Unit = {
        navController.navigate(Routes.MITARJETA_SCREEN) {
            scope.launch {
                drawerState.close()
            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToMiCuenta: () -> Unit = {
        navController.navigate(Routes.INICIO_SCREEN) {
            scope.launch {
                drawerState.close()
            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToPago: () -> Unit = {
        navController.navigate(Routes.PAGOSERVICIOS_SCREEN) {
            scope.launch {
                drawerState.close()
            }
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
            launchSingleTop = true
            restoreState = true
        }
    }

}