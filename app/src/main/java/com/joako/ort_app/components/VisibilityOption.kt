package com.joako.ort_app.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R

@Composable
fun VisibilityOption(modifier: Modifier = Modifier) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.visibility),
                    contentDescription = "Tarjeta",
                    tint = colorResource(id = R.color.purple_900),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.purple_900)
                    ), text = " Mostrar datos"
                )
            }
}