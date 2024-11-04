package com.joako.ortchall4.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.joako.ort_app.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    scope: CoroutineScope,
    drawerState: DrawerState,
    snackbarHostState: SnackbarHostState,
    viewModel: MainActivityViewModel,
) {

    TopBarInternal(
        title = { title.let { Text(it) } },
        onNavIconPressed = { viewModel.openDrawer() },
        scope = scope,
        snackbarHostState = snackbarHostState
    )
//    when (title) {
//        "Inicio" -> {
//            Text(title)
//        }
//        "Mi Cuenta" -> {
//            Text(title)
//        }
//        "Mi Tarjeta" -> {
//            Text(title)
//        }
//        "Pago de Servicios" -> {
//            Text(title)
//        }
//        else -> {
//            TopBarInternal(
//                title = { title.let { Text(it) } },
//                onNavIconPressed = { viewModel.openDrawer() },
//                scope = scope,
//                snackbarHostState = snackbarHostState
//            )
//        }
//    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarInternal(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onNavIconPressed: () -> Unit = { },
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = title,
//        actions = {
//            Icon(
//                painter = painterResource(id = R.drawable.trailing_icon),
//                contentDescription = null,
//                modifier = Modifier.padding(10.dp).size(36.dp).clickable {
//                    scope.launch {
//                        snackbarHostState.showSnackbar("Avatar")
//                    }
//                }
//            )
//        },

//        scrollBehavior = scrollBehavior,
//        navigationIcon = {
//            AppIcon(
//                contentDescription = stringResource(id = R.string.navigation_drawer_open),
//                modifier = Modifier
//                    .size(64.dp)
//                    .clickable(onClick = onNavIconPressed)
//                    .padding(16.dp)
//            )
//        }
    )
}




