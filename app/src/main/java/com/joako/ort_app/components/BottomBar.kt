package com.joako.ort_app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

val bottomNavItemList = listOf(
    BottomBarItem(
        title = "Product",
        icon = Icons.Default.Home,
        onClick = { }
    ),
    BottomBarItem(
        title = "Search",
        icon = Icons.Default.Search,
        onClick = { }
    ),
    BottomBarItem(
        title = "Cart",
        icon = Icons.Default.ShoppingCart,
        onClick = { }
    ),
    BottomBarItem(
        title = "Profile",
        icon = Icons.Default.Person,
        onClick = { }
    ),
    BottomBarItem(
        title = "Menu",
        icon = Icons.Default.Menu,
        onClick = { }
    )
)

@Composable
fun BottomBar() {
    NavigationBar {
        bottomNavItemList.forEachIndexed { _, bottomBarItem ->
            NavigationBarItem(
                icon = { bottomBarItem.icon },
                label = { bottomBarItem.title },
                selected = true,
                onClick = { TODO() }
            )
        }


    }
}