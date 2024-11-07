package com.joako.ort_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.screens.inicio.InicioScreenViewModel

@Composable
fun InicioSaldoView(modifier: Modifier = Modifier, viewModel: InicioScreenViewModel) {
    val saldoDisponible by viewModel.saldoDisponible.observeAsState("N/A")

    Column(
        modifier = Modifier.padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = TextStyle(
                fontSize = 12.sp, fontWeight = FontWeight.Bold
            ), text = stringResource(R.string.available)
        )
        Text(
            style = TextStyle(
                fontWeight = FontWeight.Black, fontSize = 44.sp
            ), text = saldoDisponible
        )
    }
}