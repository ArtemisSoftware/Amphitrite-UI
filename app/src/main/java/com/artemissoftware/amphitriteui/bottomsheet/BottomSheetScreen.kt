package com.artemissoftware.amphitriteui.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.bottomsheet.composables.*
import com.artemissoftware.amphitriteui.bottomsheet.pages.RadioPageFull
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun BottomSheetScreen() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val sheetToggle: () -> Unit = {
        scope.launch {
            if (scaffoldState.bottomSheetState.isCollapsed) {
                scaffoldState.bottomSheetState.expand()
            } else {
                scaffoldState.bottomSheetState.collapse()
            }
        }
    }
    val radius = (30 * scaffoldState.currentFraction).dp

    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(topStart = radius, topEnd = radius),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bottom Sheet",
                    modifier = Modifier
                        .padding(5.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        sheetContent = {
            SheetContent {
                SheetExpanded {
                    RadioPageFull()
                }
                SheetCollapsed(
                    isCollapsed = scaffoldState.bottomSheetState.isCollapsed,
                    currentFraction = scaffoldState.currentFraction,
                    onSheetClick = sheetToggle
                ) {
                    RadioPageMini()
                }
            }
        },
        sheetPeekHeight = 70.dp,
    ) {

    }
}

@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentFraction: Float get() {
    val fraction = bottomSheetState.progress.fraction
    val targetValue = bottomSheetState.targetValue
    val currentValue = bottomSheetState.currentValue

    return when {
        currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 0f
        currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 1f
        currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> fraction
        else -> 1f - fraction
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BottomSheetScreen()
}