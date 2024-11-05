package com.joako.ort_app.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.joako.ort_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecargaSubeTopBar(navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Carga Sube") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = {

                navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = null
                )
            }
        }
    )
}

