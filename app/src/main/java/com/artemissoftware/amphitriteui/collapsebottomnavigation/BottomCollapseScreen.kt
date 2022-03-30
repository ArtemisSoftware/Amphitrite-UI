package com.artemissoftware.amphitriteui.collapsebottomnavigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.amphitriteui.bottomsheet.BottomSheetScreen
import com.artemissoftware.amphitriteui.collapsebottomnavigation.composables.CardCollapse
import com.artemissoftware.amphitriteui.collapsebottomnavigation.composables.CollapseBottomBar
import com.artemissoftware.amphitriteui.collapsebottomnavigation.models.BottomScreen
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import kotlin.math.roundToInt

@Composable
fun BottomCollapseScreen() {

    val bottomBarHeight = 55.dp
    val bottomBarHeightPx = with(LocalDensity.current) {
        bottomBarHeight.roundToPx().toFloat()
    }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.nestedScroll(nestedScrollConnection),
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
                    .height(bottomBarHeight)
                    .offset {
                        IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())
                    }
            ) {
                CollapseBottomBar(
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