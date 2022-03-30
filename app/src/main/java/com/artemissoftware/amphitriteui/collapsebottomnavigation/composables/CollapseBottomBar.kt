package com.artemissoftware.amphitriteui.collapsebottomnavigation.composables

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.collapsebottomnavigation.BottomCollapseScreen
import com.artemissoftware.amphitriteui.collapsebottomnavigation.models.BottomScreen

@Composable
fun CollapseBottomBar(
    bottomNavigationItems: List<BottomScreen>
) {
    BottomNavigation {
        bottomNavigationItems.forEach { bottomScreen ->
            BottomNavigationItem(
                selected = false,
                onClick = {
                    //Handle bottom navigation item click
                },
                icon = {
                    Icon(
                        bottomScreen.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = bottomScreen.title
                    )
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CollapseBottomBar(bottomNavigationItems = BottomScreen.getBottomNavigationItems())
}