package com.joako.ort_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

@Composable
fun ActionButton(modifier: Modifier, iconResId: Int, label1: String, label2: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.height( 96.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label1,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(lineHeight = 1.sp),
            color = Color(0xFF300656)
        )
        Text(
            text = label2,
            fontSize = 12.sp,
            style = TextStyle(lineHeight = 16.sp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF300656)
        )
    }
}