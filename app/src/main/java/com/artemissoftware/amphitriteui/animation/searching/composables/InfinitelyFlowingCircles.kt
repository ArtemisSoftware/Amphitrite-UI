package com.artemissoftware.amphitriteui.animation.searching.composables

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InfinitelyFlowingCircles() {
    val primaryColor = MaterialTheme.colors.primary
    val frontCircle = primaryColor.copy(alpha = 0.75f)
    val midCircle = primaryColor.copy(alpha = 0.50f)
    val backCircle = primaryColor.copy(alpha = 0.25f)

    Circle(
        scale = scaleInfiniteTransition(targetValue = 2f, durationMillis = 600),
        color = backCircle,
        radiusRatio = 4f
    )
    Circle(
        scale = scaleInfiniteTransition(targetValue = 2.5f, durationMillis = 800),
        color = midCircle,
        radiusRatio = 6f
    )
    Circle(
        scale = scaleInfiniteTransition(targetValue = 3f, durationMillis = 1000),
        color = frontCircle,
        radiusRatio = 12f
    )
}

@Composable
fun scaleInfiniteTransition(
    initialValue: Float = 0f,
    targetValue: Float,
    durationMillis: Int
): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val scale: Float by infiniteTransition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    return scale
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    InfinitelyFlowingCircles()
}