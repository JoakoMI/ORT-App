package com.joako.ort_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.joako.ort_app.screens.miCuenta.MiCuentaScreen
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val drawerOpen by viewModel.drawerShouldBeOpened.collectAsState()
            val scope = rememberCoroutineScope()

            LaunchedEffect(drawerOpen) {
                if (drawerOpen) {
                    scope.launch {
                        drawerState.open()
                        viewModel.resetOpenDrawerAction()
                    }
                }
            }

            if (drawerState.isOpen) {
                BackHandler {
                    scope.launch {
                        drawerState.close()
                        viewModel.resetOpenDrawerAction()
                    }
                }
            }

            ORTApp(
                viewModel = viewModel,
                drawerState = drawerState
            )
        }
    }
}