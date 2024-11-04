package com.joako.ort_app.screens.pago

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.joako.ort_app.R
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun PagoServiciosScreen(modifier: Modifier = Modifier, navigationActions: MainNavActions, viewModel: Any) {
    Column(
        modifier = modifier.fillMaxSize().background(colorResource(id = R.color.screen_background)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pago de Servicios")
    }
}
