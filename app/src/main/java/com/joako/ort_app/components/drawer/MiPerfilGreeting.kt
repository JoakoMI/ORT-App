package com.joako.ort_app.components.drawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MiPerfilGreeting(modifier: Modifier = Modifier) {
    Text(
        text = "\uD83D\uDC4B Hola Mariana Belén",
        modifier = Modifier.padding(16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20   .sp

    )
}