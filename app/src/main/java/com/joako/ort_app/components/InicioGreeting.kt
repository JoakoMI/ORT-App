package com.joako.ort_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InicioGreeting(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(vertical = 24.dp, horizontal = 24.dp)) {
        Column {
            Text(
                style = TextStyle(
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                ), text = "\uD83D\uDC4B Hola Mariana"
            )
            Text(
                style = TextStyle(
                    fontSize = 12.sp,
                ), text = "Ultimo acceso: Mar 01, 2020 4:55 PM"
            )
        }


    }
}