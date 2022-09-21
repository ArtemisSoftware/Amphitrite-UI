package com.artemissoftware.amphitriteui.animation.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class CustomScreens (
    val id:String,
    val title:String,
    val icon: ImageVector,
){



    object Home:CustomScreens("home","Home", Icons.Outlined.Home)
    object Search:CustomScreens("seacrh","Search",Icons.Outlined.Search)
    object Profile:CustomScreens("profile","Profile",Icons.Outlined.Person)
    object Settings:CustomScreens("settings","Settings",Icons.Outlined.Settings)

    object Items{
        val list= listOf(
            Home,Search,Profile,Settings
        )
    }

}