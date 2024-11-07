package com.joako.ort_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.screens.inicio.InicioScreenViewModel

fun String.capitalizeFirstLetter(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

@Composable
fun InicioGreeting(modifier: Modifier = Modifier, viewModel: InicioScreenViewModel) {
    val userName by viewModel.firstName.collectAsState()

    Row(modifier = modifier.padding(vertical = 24.dp, horizontal = 24.dp)) {
        Column {
            Text(
                style = TextStyle(
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                ), text = stringResource(R.string.greeting) + " " + userName.capitalizeFirstLetter()
            )
            Text(
                style = TextStyle(
                    fontSize = 12.sp,
                ), text = stringResource(R.string.accsess)
            )
        }
    }
}