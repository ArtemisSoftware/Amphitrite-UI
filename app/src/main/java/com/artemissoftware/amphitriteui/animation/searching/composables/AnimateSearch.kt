package com.artemissoftware.amphitriteui.animation.searching.composables

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AnimateSearch() {

    val animateCircle = remember { Animatable(0f) }.apply {
        AnimateShapeInfinitely(animateShape = this)
    }
    val animateLine = remember { Animatable(0.6f) }.apply {
        AnimateShapeInfinitely(animateShape = this)
    }


    val surfaceColor = MaterialTheme.colors.surface

    Canvas(
        modifier = Modifier
    ) {
        drawArc(
            color = surfaceColor,
            startAngle = 45f,
            sweepAngle = 360f * animateCircle.value,
            useCenter = false,
            size = Size(80f, 80f),
            style = Stroke(16f, cap = StrokeCap.Round)
        )

        drawLine(
            color = surfaceColor,
            strokeWidth = 16f,
            cap = StrokeCap.Round,
            start = Offset(
                animateLine.value * 80f,
                animateLine.value * 80f
            ),
            end = Offset(
                animateLine.value * 110f,
                animateLine.value * 110f
            )
        )
    }
}


@Composable
private fun AnimateShapeInfinitely(
    animateShape: Animatable<Float, AnimationVector1D>,
    targetValue: Float = 1f,
    durationMillis: Int = 1000
) {
    LaunchedEffect(animateShape) {
        animateShape.animateTo(
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        AnimateSearch()
    }
}
