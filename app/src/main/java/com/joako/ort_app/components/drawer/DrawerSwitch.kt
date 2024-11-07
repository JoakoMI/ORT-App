package com.joako.ort_app.components.drawer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R

@Composable
fun DrawerSwitch(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.White),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isChecked) "Dark Mode ON" else "Dark Mode OFF",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = androidx.compose.ui.graphics.Color.Gray,
                    checkedThumbColor = androidx.compose.ui.graphics.Color.Green,
                    uncheckedBorderColor = androidx.compose.ui.graphics.Color.White,
                    uncheckedThumbColor = androidx.compose.ui.graphics.Color.White,
                    uncheckedTrackColor = androidx.compose.ui.graphics.Color.LightGray
                )
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun MySwitchPreview() {
    DrawerSwitch()
}

