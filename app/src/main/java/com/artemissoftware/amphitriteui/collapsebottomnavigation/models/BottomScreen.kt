package com.artemissoftware.amphitriteui.collapsebottomnavigation.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
    ) {
    object Home: BottomScreen("home", "Home", Icons.Filled.Home)
    object Favourite: BottomScreen("favourite", "Favourite", Icons.Filled.Favorite)
    object Search: BottomScreen("search", "Search", Icons.Filled.Search)
    object Setting: BottomScreen("setting", "Setting", Icons.Filled.Settings)
    object User: BottomScreen("user", "User", Icons.Filled.Person)

    companion object{
        fun getBottomNavigationItems() = listOf(
            Home,
            Favourite,
            Search,
            Setting,
            User
        )
    }
}
