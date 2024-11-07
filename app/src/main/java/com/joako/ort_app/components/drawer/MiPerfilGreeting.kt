package com.joako.ort_app.components.drawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.screens.inicio.InicioScreenViewModel

@Composable
fun MiPerfilGreeting(modifier: Modifier = Modifier, viewModel: InicioScreenViewModel) {
    val firstName by viewModel.firstName.collectAsState()
    val lastName by viewModel.lastName.collectAsState()
    Text(
        text = "\uD83D\uDC4B Hola $firstName $lastName",
        modifier = Modifier.padding(16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20   .sp

    )
}