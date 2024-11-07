package com.joako.ort_app.components.scaffold

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.joako.ort_app.MainActivityViewModel
import com.joako.ort_app.R
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
        scope = scope
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
    scope: CoroutineScope
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = title,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(R.color.screen_background)
        )
    )
}




