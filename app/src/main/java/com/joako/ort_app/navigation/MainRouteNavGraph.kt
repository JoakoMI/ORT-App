package com.joako.ort_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.MainActivityViewModel

@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainActivityViewModel,
    openDrawer: () -> Unit = {},

    ) {}