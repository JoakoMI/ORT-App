package com.joako.ort_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.joako.ort_app.components.BottomBar
import com.joako.ort_app.screens.miCuenta.MiCuentaScreen
import com.joako.ort_app.ui.theme.ORTAppTheme
import com.joako.ortchall4.components.TopBar

@Composable
fun ORTApp(modifier: Modifier = Modifier, viewModel: MainActivityViewModel = viewModel(factory = MainActivityViewModel.Factory),
           drawerState: DrawerState
) {
    ORTAppTheme {

        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
//        val title: String by viewModel.titleBar.observeAsState(stringResource(R.string.title_bar_default))
        val title = "Title"
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopBar(title, scope, drawerState, snackbarHostState, viewModel)
            },
            bottomBar = {
                BottomBar()
            },
        )
        
        { innerPadding ->
            MiCuentaScreen(
                modifier = Modifier.padding(innerPadding),
                viewModel = viewModel
            )
//            Greeting(
//                name = "Android",
//                modifier = Modifier.padding(innerPadding)
//            )
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier) {
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
    Text(text = "Hello $name!", modifier = modifier)
    }
}
