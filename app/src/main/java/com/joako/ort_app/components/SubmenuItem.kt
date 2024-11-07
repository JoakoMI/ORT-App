package com.joako.ort_app.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R

@Composable
fun SubmenuItem(modifier: Modifier = Modifier, text:String) {
    val text = text
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.black)
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.btn),
            contentDescription = "Arrow btn",
            modifier = Modifier.align(Alignment.CenterVertically),
            tint = Color.Unspecified

        )
    }
}

