package com.joako.ort_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.joako.ort_app.screens.SignInScreen
import com.joako.ort_app.screens.SignInScreenViewModel
import com.joako.ort_app.ui.theme.ORTAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ORTAppTheme {
                SignInScreen(
                    viewModel = SignInScreenViewModel.viewModel
                )
            }
        }
    }
}