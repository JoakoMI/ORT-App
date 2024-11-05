package com.joako.ort_app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joako.ort_app.screens.pago.Option

@Composable
fun OptionCardRow(options: List<Option>, onOptionClick: (Option) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        options.forEach { option ->
            OptionCard(
                option = option,
                modifier = Modifier.weight(1f),
                onClick = { onOptionClick(option) }
            )
        }
    }
}

