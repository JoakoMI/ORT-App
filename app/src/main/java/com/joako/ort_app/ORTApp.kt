package com.joako.ort_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.components.BottomBar
import com.joako.ort_app.navigation.MainNavActions
import com.joako.ort_app.navigation.MainRouteNavGraph
import com.joako.ort_app.navigation.Routes
import com.joako.ort_app.screens.miCuenta.MiCuentaScreen
import com.joako.ort_app.ui.theme.ORTAppTheme
import com.joako.ortchall4.components.TopBar

@Composable
fun ORTApp(
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel = viewModel(factory = MainActivityViewModel.Factory),
    drawerState: DrawerState
) {
    ORTAppTheme {
        val navController = rememberNavController()
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        val title: String by viewModel.titleBar.observeAsState("Com")

        val navigationActions = remember(navController) {
            MainNavActions(navController, scope, drawerState)
        }

        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        val showBars = currentRoute != Routes.SIGNIN_SCREEN

        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                if (showBars) {
                    TopBar(title, scope, drawerState, snackbarHostState, viewModel)
                }
            },
            bottomBar = {
                if (showBars) {
                    BottomBar(navigationActions, viewModel)
                }
            },
        ) { innerPadding ->
            MainRouteNavGraph(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                viewModel = viewModel,
                navigationActions = navigationActions,
                retrofitInstance = viewModel.retrofitInstance,
            )
        }
    }
}


