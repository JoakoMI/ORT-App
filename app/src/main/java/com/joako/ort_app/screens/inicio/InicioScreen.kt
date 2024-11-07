package com.joako.ort_app.screens.inicio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.joako.ort_app.components.VisibilityOption
import com.joako.ort_app.R
import com.joako.ort_app.components.CardMock
import com.joako.ort_app.components.InicioAlert
import com.joako.ort_app.components.InicioButtonRow
import com.joako.ort_app.components.InicioGreeting
import com.joako.ort_app.components.InicioSaldoView
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun InicioScreen(
    modifier: Modifier = Modifier,
    navigationActions: MainNavActions,
    viewModel: InicioScreenViewModel,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.screen_background)),
        ) {
            InicioGreeting(modifier = modifier, viewModel = viewModel)

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CardMock()

                Spacer(modifier = Modifier.weight(1f))

                VisibilityOption()

                InicioSaldoView(viewModel = viewModel)

                InicioAlert()
            }
            Spacer(modifier = Modifier.weight(1f))

            InicioButtonRow(modifier = modifier, navigationActions = navigationActions)

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}