package com.joako.ort_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.joako.ort_app.R
import com.joako.ort_app.navigation.MainNavActions


@Composable
fun AppDrawer(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    navigationActions: MainNavActions,
    content: @Composable () -> Unit,
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MenuDrawerContent(navigationActions)
            }
        },
        content = content
    )
}


@Composable
fun MenuDrawerContent(navigationActions: MainNavActions) {
    Column(
        modifier = Modifier
            .fillMaxSize().padding(horizontal = 12.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Mi Perfil",
            modifier = Modifier.padding(18.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Image(
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Avatar",

            )

        Text(
            text = "\uD83D\uDC4B Hola Mariana Belén",
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20   .sp

        )

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(containerColor = Color.White)

        ) {
            Column() {
                SubmenuItem(
                    modifier = Modifier,
                    text = "Mis datos"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    color = colorResource(id = R.color.gray_500)
                )
                SubmenuItem(
                    modifier = Modifier,
                    text = "Mi CVU"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    color = colorResource(id = R.color.gray_500)
                )
                SubmenuItem(
                    modifier = Modifier,
                    text = "Configuración"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    color = colorResource(id = R.color.gray_500)
                )
                SubmenuItem(
                    modifier = Modifier,
                    text = "Ayuda"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    color = colorResource(id = R.color.gray_500)
                )
                SubmenuItem(
                    modifier = Modifier,
                    text = "Términos y condiciones"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    color = colorResource(id = R.color.gray_500)
                )
                SubmenuItem(
                    modifier = Modifier,
                    text = "Cerrar sesión"
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp),
                    color = colorResource(id = R.color.gray_500)
                )
            }


        }
        Spacer(modifier = Modifier.weight(1f))

        Card(
            modifier = Modifier
                .fillMaxWidth()
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
                    text = "Dark Mode",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = false,
                    onCheckedChange = { /*TODO*/ },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(id = R.color.icons_selected),
                        checkedTrackColor = colorResource(id = R.color.icons_selected),
                        uncheckedThumbColor = colorResource(id = R.color.black),
                        uncheckedTrackColor = colorResource(id = R.color.black)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
@Preview("Drawer Menu Opened")
private fun Preview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val navigationActions = remember(navController) {
        MainNavActions(navController, scope, drawerState)
    }

    AppDrawer(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
        navigationActions = navigationActions,
        content = {}
    )
}

