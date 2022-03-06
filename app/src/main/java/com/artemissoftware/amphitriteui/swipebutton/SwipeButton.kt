package com.artemissoftware.amphitriteui.swipebutton

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.ui.theme.GreenColor
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun SwipeButton(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {

    val width = 350.dp
    val dragSize = 50.dp

    val sizePx = with(LocalDensity.current) {
        (width - dragSize).toPx()
    }

    val swipeableState = rememberSwipeableState(initialValue = ConfirmationState.DEFAULT)
    val anchors = mapOf(0f to ConfirmationState.DEFAULT, sizePx to ConfirmationState.CONFIRMED)

    val progress = derivedStateOf {
        if (swipeableState.offset.value == 0f) 0f else swipeableState.offset.value / sizePx
    }

    Box(
        modifier = modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            )
            .background(GreenColor, RoundedCornerShape(dragSize))
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(1f - progress.value),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Order 1000 gil",
                color = textColor,
                fontSize = 18.sp
            )
            Text(
                text = "Swipe to Confirm",
                color = textColor,
                fontSize = 12.sp
            )
        }

        DraggableControl(
            modifier = Modifier
                .offset {
                    IntOffset(swipeableState.offset.value.roundToInt(), 0)
                }
                .size(dragSize),
            progress = progress.value
        )
    }
}

@Composable
private fun DraggableControl(
    modifier: Modifier,
    progress: Float
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .shadow(
                elevation = 2.dp,
                shape = CircleShape,
                clip = false
            )
            .background(Color.White, CircleShape),
        contentAlignment = Alignment.Center
    ) {

        val isConfirmed = derivedStateOf { progress >= 0.8f }

        Crossfade(
            targetState = isConfirmed.value
        ) {
            if (it) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Confirm Icon",
                    tint = GreenColor
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Forward Icon",
                    tint = GreenColor
                )
            }
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Column {

        DraggableControl(
            modifier = Modifier,
            progress = 0.3f
        )

        Spacer(modifier = Modifier.height(12.dp))

        DraggableControl(
            modifier = Modifier,
            progress = 1f
        )

        Spacer(modifier = Modifier.height(12.dp))

        SwipeButton(
            textColor = Color.White
        )
    }


}