package com.artemissoftware.amphitriteui.collapsebottomnavigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.bottomsheet.BottomSheetScreen
import com.artemissoftware.amphitriteui.collapsebottomnavigation.composables.CardCollapse
import com.artemissoftware.amphitriteui.collapsebottomnavigation.composables.CollapseBottomBar
import com.artemissoftware.amphitriteui.collapsebottomnavigation.models.BottomScreen
import com.artemissoftware.amphitriteui.ui.theme.Purple500

@Composable
fun BottomCollapseScreen() {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
//        modifier = Modifier.nestedScroll(nestedScrollConnection),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Collapse Bottom Navigation",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                backgroundColor = Purple500,
                elevation = AppBarDefaults.TopAppBarElevation
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
//                    .height(bottomBarHeight)
//                    .offset {
//                        IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())
//                    }
            ) {
                CollapseBottomBar(
                    //navController,
                    bottomNavigationItems = BottomScreen.getBottomNavigationItems()
                )
            }
        },
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(count = 20) {
                    CardCollapse()
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BottomCollapseScreen()
}