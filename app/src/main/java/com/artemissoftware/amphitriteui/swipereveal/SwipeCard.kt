package com.artemissoftware.amphitriteui.swipereveal

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.swipereveal.composables.SwipeCardContent
import com.artemissoftware.amphitriteui.swipereveal.composables.SwipeRevealOptions
import com.artemissoftware.amphitriteui.ui.theme.LightGray100
import com.artemissoftware.amphitriteui.ui.theme.Purple200
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun SwipeCard() {


    var bgColor = remember { mutableStateOf(Purple200) }

    val color = animateColorAsState(
        targetValue = bgColor.value,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    val squareSize = 80.dp
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }

    val swipeAbleState = rememberSwipeableState(initialValue = 0)
    val anchors = mapOf(0f to 0, sizePx to 1)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(LightGray100)
                .swipeable(
                    state = swipeAbleState,
                    anchors = anchors,
                    thresholds = { _, _ ->
                        FractionalThreshold(0.3f)
                    },
                    orientation = Orientation.Horizontal
                )
        ) {

            SwipeRevealOptions(bgColor)

            Box(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            swipeAbleState.offset.value.roundToInt(), 0
                        )
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .background(color.value)
            ) {
                SwipeCardContent()
            }
        }
    }

}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SwipeCard()
}