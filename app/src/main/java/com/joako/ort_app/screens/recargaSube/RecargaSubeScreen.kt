package com.joako.ort_app.screens.recargaSube

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.joako.ort_app.R
import com.joako.ort_app.components.RecargaSubeCard
import com.joako.ort_app.navigation.MainNavActions


@Composable
fun RecargaSubeScreen(
    navController: NavController, navActions: MainNavActions,
    viewModel: RecargaSubeScreenViewModel = viewModel()
) {
    val amount = viewModel.amount.observeAsState()
    val cardNumber = viewModel.cardNumber.observeAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Verificá que la información sea\ncorrecta:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2A1846),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            RecargaSubeCard(
                cardNumber = viewModel.cardNumber.value ?: "",
                amount = viewModel.amount.value ?: ""
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                onClick = viewModel.getNavigationAction(navActions),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(48.dp)
                    .background(Color(0xFF442E83), RoundedCornerShape(24.dp)),
                content = {
                    Text(
                        text = "Continuar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            )
        }
    }


