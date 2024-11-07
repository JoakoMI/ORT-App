package com.joako.ort_app.components.scaffold

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
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
    viewModel: MainActivityViewModel,
) {

    TopBarInternal(
        title = { title.let { Text(it) } },
        onNavIconPressed = { viewModel.openDrawer() },
        scope = scope,
    )

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
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = title,


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




