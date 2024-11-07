package com.joako.ort_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joako.ort_app.R

@Composable
fun CardMock(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.tarjetapng),
        contentDescription = "Logo",
        modifier = Modifier
            .width(336.dp)
            .height(212.dp)
    )
}