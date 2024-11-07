package com.joako.ort_app.screens.inicio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background)),
    ) {
        InicioGreeting(modifier = modifier)


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CardMock()

            Spacer(modifier = Modifier.height(8.dp))

            VisibilityOption()

            InicioSaldoView()

            InicioAlert()


        }
        Spacer(modifier = Modifier.height(24.dp))

        InicioButtonRow(modifier = modifier, navigationActions = navigationActions)



    }
}


