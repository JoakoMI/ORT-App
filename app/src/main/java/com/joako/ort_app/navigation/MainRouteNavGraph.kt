package com.joako.ort_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.data.RetroFitInstance

@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainActivityViewModel,
    openDrawer: () -> Unit = {},
//    startDestination: String = Routes.MAIN_LIST_SCREEN,
//    navigationActions: MainNavActions,
    retrofitInstance: RetroFitInstance
) {
//    NavHost(
//        navController = navController,
//        startDestination = startDestination,
//        modifier = modifier
//    )
}