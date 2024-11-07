package com.joako.ort_app.screens.pago

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.joako.ort_app.R
import com.joako.ort_app.components.OptionCard
import com.joako.ort_app.components.OptionCardRow
import com.joako.ort_app.navigation.MainNavActions

@Composable
fun PagoServiciosScreen(
    modifier: Modifier = Modifier,
    navigationActions: MainNavActions,
    viewModel: PagoServiciosScreenViewModel
) {
    val options = viewModel.options

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.screen_background)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (modifier.padding(12.dp)){
            options.chunked(2).forEach { rowOptions ->
                OptionCardRow(
                    options = rowOptions,
                    onOptionClick = { option ->
                        viewModel.getNavigationAction(option.id, navigationActions).invoke()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}