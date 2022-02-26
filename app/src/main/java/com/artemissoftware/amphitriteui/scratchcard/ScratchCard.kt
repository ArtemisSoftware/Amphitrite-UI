package com.artemissoftware.amphitriteui.scratchcard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@ExperimentalComposeUiApi
@Composable
fun ScratchCard() {

    val currentPathState = remember { mutableStateOf(DraggedPath(path = Path())) }
    val movedOffsetState = remember { mutableStateOf<Offset?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScratchCanvas(
            overlayImage = R.drawable.prize_overlay,
            baseImage = R.drawable.artemis_4,
            movedOffset = movedOffsetState.value,
            onMovedOffset = { x, y ->
                movedOffsetState.value = Offset(x, y)
            },
            currentPath = currentPathState.value.path,
            currentPathThickness = currentPathState.value.width,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ScratchCard()
}