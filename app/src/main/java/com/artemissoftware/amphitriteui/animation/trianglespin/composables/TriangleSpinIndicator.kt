package com.artemissoftware.amphitriteui.animation.trianglespin

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TriangleSpinIndicator() {
    val animationSpec = infiniteRepeatable<Float>(
        animation = tween(
            durationMillis = 2500,
            easing = LinearEasing,
        )
    )
    val xRotation by AnimateValues(
        values = listOf(0f, 180f, 180f, 0f, 0f),
        animationSpec = animationSpec
    )
    val yRotation by AnimateValues(
        values = listOf(0f, 0f, 180f, 180f, 0f),
        animationSpec = animationSpec
    )

    Triangle(
        modifier = Modifier.graphicsLayer(
            rotationX = xRotation,
            rotationY = yRotation,
        )
    )
}

@Preview
@Composable
fun TriangleSpinIndicatorPreview() {
    TriangleSpinIndicator()
}