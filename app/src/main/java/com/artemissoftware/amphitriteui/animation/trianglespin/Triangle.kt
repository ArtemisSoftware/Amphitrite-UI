package com.artemissoftware.amphitriteui.animation.trianglespin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.customshapes.composables.Donut

@Composable
fun Triangle(
    modifier: Modifier = Modifier,
    size: Dp = 120.dp,
    backgroundColor: Color = Color.Red,
) {
    Box(
        modifier = modifier
            .size(size)
            .clipToBounds()
            .background(backgroundColor, TriangleShape)
    )
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Triangle(Modifier)
}