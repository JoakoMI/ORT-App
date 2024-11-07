package com.joako.ort_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.screens.signIn.goldmanSans

@Composable
fun SignInPhrase(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .background(Color(0xFFDAE9FC), shape = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = stringResource(R.string.signin_phrase_1),
                    color = Color(0xFF1E0A3C),
                    fontSize = 20.sp,
                    fontFamily = goldmanSans
                )
            }
            Row(
                modifier = Modifier
                    .background(Color(0xFF00A067).copy(alpha = 0.6f), shape = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(text = "😊", fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .background(Color(0xFF00A067).copy(alpha = 0.6f), shape = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 6.dp),
            ) {
                Text(text = "🙌", fontSize = 20.sp)
            }
            Row(
                modifier = Modifier
                    .background(Color(0xFFDAE9FC), shape = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = stringResource(R.string.signin_phrase_2),
                    color = Color(0xFF1E0A3C),
                    fontSize = 20.sp,
                    fontFamily = goldmanSans
                )
            }
        }
    }
}