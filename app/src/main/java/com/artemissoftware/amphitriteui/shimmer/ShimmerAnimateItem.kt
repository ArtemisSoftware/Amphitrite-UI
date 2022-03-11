package com.artemissoftware.amphitriteui.shimmer

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.util.Constants.SHIMMER_COLORS

@Composable
fun ShimmerAnimateItem(
    content: @Composable() (Brush) -> Unit
) {

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = SHIMMER_COLORS,
        start = Offset(10f, 10f),
        end = Offset(translateAnim.value, translateAnim.value)
    )
    content(brush)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
//    ShimmerAnimateItem()
}