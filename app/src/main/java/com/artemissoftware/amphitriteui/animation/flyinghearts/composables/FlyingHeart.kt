package com.artemissoftware.amphitriteui.animation.flyinghearts.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.animation.flyinghearts.HeartState
import com.artemissoftware.amphitriteui.customshapes.extensions.heartPath

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FlyingHeart(
    modifier: Modifier = Modifier,
    horizontalPadding: Int,
    bottomMargin: Int
) {

    val state = remember { mutableStateOf(HeartState.Show) }

    val width = LocalConfiguration.current.screenWidthDp
    val height = LocalConfiguration.current.screenHeightDp - bottomMargin

    val yRandom =  (0.. height / 2).random()
    val xRandom = (horizontalPadding.. (width - horizontalPadding)).random()


    val offsetYAnimation: Dp by animateDpAsState(
        targetValue = when (state.value) {
            HeartState.Show -> height.dp
            else -> yRandom.dp
        },
        animationSpec = tween(1000)
    )

    val offsetXAnimation: Dp by animateDpAsState(
        targetValue = when (state.value) {
            HeartState.Show -> (((width - (horizontalPadding * 2)) / 2) + 8).dp
            else -> xRandom.dp
        },
        animationSpec = tween(1000)
    )

    LaunchedEffect(key1 = state, block = {
        state.value = when (state.value) {
            HeartState.Show -> HeartState.Hide
            HeartState.Hide -> HeartState.Show
        }
    })

    AnimatedVisibility(
        visible = state.value == HeartState.Show,
        enter = fadeIn(animationSpec = tween(durationMillis = 250)),
        exit = fadeOut(animationSpec = tween(durationMillis = 700))
    ) {
        Canvas(modifier = modifier
            .offset(y = offsetYAnimation, x = offsetXAnimation),
            onDraw = {
                val path = Path().apply {
                    heartPath(Size(120f, 120f))
                }
                drawPath(
                    path = path,
                    color = Color.Red,
                )
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    FlyingHeart(
        modifier = Modifier
            .fillMaxSize(),
        horizontalPadding = 24,
        bottomMargin = 110
    )
}