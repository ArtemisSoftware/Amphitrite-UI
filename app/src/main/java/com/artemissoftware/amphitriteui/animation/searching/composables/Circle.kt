package com.artemissoftware.amphitriteui.animation.searching.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Circle(
    scale: Float,
    color: Color,
    radiusRatio: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawCircle(
            color = color,
            center = Offset(
                x = canvasWidth / 2,
                y = canvasHeight / 2
            ),
            radius = size.minDimension / radiusRatio
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Column {
        //Circle(scale = 0.1f, color = Color.Green, radiusRatio = 0.1f)
        //Circle(scale = 0.3f, color = Color.Red, radiusRatio = 0.3f)
        Circle(scale = 0.8f, color = Color.Blue, radiusRatio = 16f)
    }


}