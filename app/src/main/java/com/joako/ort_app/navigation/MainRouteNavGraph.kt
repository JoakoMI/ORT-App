package com.joako.ort_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.screens.confirmacionSube.ConfirmacionSubeScreen
import com.joako.ort_app.screens.confirmacionSube.ConfirmacionSubeScreenViewModel
import com.joako.ort_app.screens.inicio.InicioScreen
import com.joako.ort_app.screens.inicio.InicioScreenViewModel
import com.joako.ort_app.screens.miCuenta.MiCuentaScreen
import com.joako.ort_app.screens.miCuenta.MiCuentaScreenViewModel
import com.joako.ort_app.screens.miTarjeta.MiTarjetaScreen
import com.joako.ort_app.screens.miTarjeta.MiTarjetaScreenViewModel
import com.joako.ort_app.screens.pago.PagoServiciosScreen
import com.joako.ort_app.screens.pago.PagoServiciosScreenViewModel
import com.joako.ort_app.screens.recargaSube.RecargaSubeScreen
import com.joako.ort_app.screens.recargaSube.RecargaSubeScreenViewModel
import com.joako.ort_app.screens.signIn.SignInScreen
import com.joako.ort_app.screens.signIn.SignInScreenViewModel

@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainActivityViewModel,
    openDrawer: () -> Unit = {},
    startDestination: String = Routes.SIGNIN_SCREEN,
    navigationActions: MainNavActions,
    retrofitInstance: RetroFitInstance
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            route = Routes.SPLASH_SCREEN,
        ) {
        }

        composable(
            route = Routes.SIGNIN_SCREEN,
        ) {
            val signInViewModel: SignInScreenViewModel = viewModel(
                factory = SignInScreenViewModel.provideFactory(retrofitInstance)
            )

            SignInScreen(
                navigationActions = navigationActions,
                viewModel = signInViewModel,
                navController = navController,
                mainViewModel = viewModel
            )
        }

        composable(
            route = Routes.INICIO_SCREEN,
        ) {
            val inicioViewModel: InicioScreenViewModel = viewModel(
                factory = InicioScreenViewModel.provideFactory(retrofitInstance)
            )
            viewModel.setTitleBar("Inicio")
            InicioScreen(
                navigationActions = navigationActions,
                viewModel = inicioViewModel
            )

        }

        composable(
            route = Routes.MICUENTA_SCREEN,
        ) {
            val miCuentaScreenViewModel: MiCuentaScreenViewModel = viewModel(
                factory = MiCuentaScreenViewModel.provideFactory(retrofitInstance)
            )
            viewModel.setTitleBar("Mi Cuenta")
            MiCuentaScreen(
                navigationActions = navigationActions,
                viewModel = miCuentaScreenViewModel
            )

        }

        composable(
            route = Routes.MITARJETA_SCREEN,
        ) {
            val miTarjetaViewModel: MiTarjetaScreenViewModel = viewModel(
                factory = MiTarjetaScreenViewModel.provideFactory(retrofitInstance)
            )
            viewModel.setTitleBar("Mi Tarjeta")
            MiTarjetaScreen(
                navigationActions = navigationActions,
                viewModel = miTarjetaViewModel
            )

        }

        composable(
            route = Routes.PAGOSERVICIOS_SCREEN,
        ) {
            val pagoServiciosScreenViewModel: PagoServiciosScreenViewModel = viewModel(
                factory = PagoServiciosScreenViewModel.provideFactory(retrofitInstance)
            )
            viewModel.setTitleBar("Pago de Servicios")
            PagoServiciosScreen(
                navigationActions = navigationActions,
                viewModel = pagoServiciosScreenViewModel
            )
        }

        composable(
            route = Routes.RECARGASUBE_SCREEN,
        ) {
            val recargaSubeScreenViewModel: RecargaSubeScreenViewModel = viewModel(
                factory = RecargaSubeScreenViewModel.provideFactory(retrofitInstance)
            )
            RecargaSubeScreen(
                navController = navController,
                viewModel = recargaSubeScreenViewModel,
                navActions = navigationActions,
            )
        }

        composable(
            route = Routes.CONFIRMACION_SUBE_SCREEN,
        ) {
            val confirmacionSubeScreenViewModel: ConfirmacionSubeScreenViewModel = viewModel(
                factory = ConfirmacionSubeScreenViewModel.provideFactory(retrofitInstance)
            )
            ConfirmacionSubeScreen(
                navController = navController,
                viewModelConfirmacion = confirmacionSubeScreenViewModel,
                navActions = navigationActions
            )
        }
    }
}