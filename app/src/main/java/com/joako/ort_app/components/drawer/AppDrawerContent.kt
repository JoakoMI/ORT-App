package com.joako.ort_app.components.drawer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joako.ort_app.R
import com.joako.ort_app.components.SubmenuItem
import com.joako.ort_app.navigation.MainNavActions
import com.joako.ort_app.screens.inicio.InicioScreenViewModel

@Composable
fun MenuDrawerContent(navigationActions: MainNavActions, viewModel: InicioScreenViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .padding(horizontal = 12.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.mi_perfil),
            modifier = Modifier.padding(18.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Image(
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.profilepng),
            contentDescription = "Avatar",

            )
        MiPerfilGreeting(viewModel = viewModel)

        Spacer(modifier = Modifier.height(40.dp))


        DrawerItemContainer()


        Spacer(modifier = Modifier.weight(1f))

        DrawerSwitch()

        Spacer(modifier = Modifier.weight(1f))
    }
}