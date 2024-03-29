package com.artemissoftware.amphitriteui.animation.clock.composables

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

enum class dd{
    isPlaying , stop, pause
}

@Composable
fun Clock(
    modifier: Modifier = Modifier,
    animationStart: MutableState<Boolean>
) {
    var currentAngle = 0f
    var previousT = 0f
    var fff = 0f

    var currentRotation by remember { mutableStateOf(0f) }
    val animatedFloat = remember { Animatable(currentRotation) }



    val scope = rememberCoroutineScope()

    val handColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Canvas(modifier = modifier) {

        scope.launch {
            if (animatedFloat.isRunning && !animationStart.value) {
                animatedFloat.stop()
            } else if(!animatedFloat.isRunning && animationStart.value) {
                animatedFloat.snapTo(0f)
                animatedFloat.animateTo(
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = 2000, easing = LinearEasing),
                    )
                )
                currentAngle = 0f
                previousT = 0f
            }
        }


        val t = animatedFloat.value
        val middle = Offset(size.minDimension / 2, size.minDimension / 2)

        drawCircle(
            color = handColor,
            center = middle,
            radius = size.minDimension / 2,
            style = Stroke(4.dp.toPx()),
        )

        withTransform(
            transformBlock = {
                if (previousT > t) {
                    currentAngle += 360 / 60
                }
                previousT = t
                rotate(currentAngle, middle)
            },
            drawBlock = {
                drawLine(
                    cap = StrokeCap.Round,
                    strokeWidth = 12.dp.toPx(),
                    color = handColor,
                    start = middle,
                    end = Offset(size.minDimension / 2, 36.dp.toPx()))
            }
        )

        withTransform(
            transformBlock = {
                rotate(360 * previousT, middle)
            },
            drawBlock = {
                drawLine(strokeWidth = 8.dp.toPx(),
                    cap = StrokeCap.Round,
                    color = Color.Red,
                    start = middle,
                    end = Offset(size.minDimension / 2, 12.dp.toPx()))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    val animationStart = remember { mutableStateOf(true) }
    Clock(modifier = Modifier
        .aspectRatio(1.0f).padding(10.dp),
        animationStart = animationStart)
}
