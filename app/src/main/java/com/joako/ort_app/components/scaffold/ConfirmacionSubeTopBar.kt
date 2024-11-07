package com.joako.ort_app.components.scaffold

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.joako.ort_app.R
import com.joako.ort_app.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmacionSubeTopBar(navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Carga Sube") },
        actions = {
            IconButton(onClick = {

                navController.navigate(Routes.INICIO_SCREEN) }) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = null
                )
            }
        }
    )
}