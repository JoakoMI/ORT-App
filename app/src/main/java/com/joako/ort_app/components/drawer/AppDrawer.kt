package com.joako.ort_app.components.drawer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.data.retrofit.RetroFitInstance
import com.joako.ort_app.navigation.MainNavActions
import com.joako.ort_app.screens.inicio.InicioScreenViewModel


@Composable
fun AppDrawer(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    navigationActions: MainNavActions,
    content: @Composable () -> Unit,
    viewModel: InicioScreenViewModel
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MenuDrawerContent(navigationActions, viewModel)
            }
        },
        content = content,
        gesturesEnabled = drawerState.isOpen,
        modifier = Modifier.fillMaxSize()
    )
}





@Composable
@Preview()
private fun Preview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val viewModel: MainActivityViewModel = viewModel(factory = MainActivityViewModel.Factory)
    val snackbarHostState = remember { SnackbarHostState() }
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState, viewModel)
    }

    AppDrawer(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
        navigationActions = navigationActions,
        content = {},
        viewModel = viewModel(factory = InicioScreenViewModel.provideFactory(RetroFitInstance))
    )
}

