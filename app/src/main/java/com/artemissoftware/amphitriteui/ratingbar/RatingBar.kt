package com.artemissoftware.amphitriteui.ratingbar

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.toSize
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.ratingbar.models.RatingBarStyle
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.util.RatingBarUtils
import com.artemissoftware.amphitriteui.util.RatingBarUtils.stepSized
import com.artemissoftware.amphitriteui.util.RatingStarConfig


@ExperimentalComposeUiApi
@Composable
fun RatingBar(){

    var rating: Float by rememberSaveable { mutableStateOf(2.5f) }

    RatingBarContent(
        value = rating,
        onValueChange = {
            rating = it
        },
        onRatingChanged = {
            Log.d("Rating Value", "RatingBarView: $it")
        },
        config = RatingStarConfig()
            .style(RatingBarStyle.HighLighted)
    )

}


@ExperimentalComposeUiApi
@Composable
private fun RatingBarContent(
    value: Float,
    modifier: Modifier = Modifier,
    config: RatingStarConfig = RatingStarConfig(),
    onValueChange: (Float) -> Unit,
    onRatingChanged: (Float) -> Unit
) {


    var rowSize by remember { mutableStateOf(Size.Zero) }
    var lastDraggedValue by remember { mutableStateOf(0f) }
    val direction = LocalLayoutDirection.current


    Row(modifier = modifier
        .onSizeChanged { rowSize = it.toSize() }
        .pointerInput(
            Unit
        ) {
            detectHorizontalDragGestures(
                onDragEnd = {
                    if (config.isIndicator || config.hideInactiveStars)
                        return@detectHorizontalDragGestures
                    onRatingChanged(lastDraggedValue)
                },
                onDragCancel = {},
                onDragStart = {},
                onHorizontalDrag = { change, _ ->

                    if (config.isIndicator || config.hideInactiveStars)
                        return@detectHorizontalDragGestures

                    change.consumeAllChanges()

                    val x1 = change.position.x.coerceIn(0f, rowSize.width)

                    val calculatedStars =
                        RatingBarUtils.calculateStars(
                            x1,
                            rowSize.width,
                            config.numStars,
                            config.padding.value.toInt()
                        )

                    var newValue =
                        calculatedStars
                            .stepSized(config.stepSize)
                            .coerceIn(0f, config.numStars.toFloat())

                    if (direction == LayoutDirection.Rtl)
                        newValue = config.numStars - newValue

                    onValueChange(newValue)
                    lastDraggedValue = newValue
                }
            )
        }
        .pointerInteropFilter {

            if (config.isIndicator || config.hideInactiveStars)
                return@pointerInteropFilter false

            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    //handling when click events
                    val calculatedStars =
                        RatingBarUtils.calculateStars(
                            it.x,
                            rowSize.width,
                            config.numStars,
                            config.padding.value.toInt()
                        )
                    var newValue =
                        calculatedStars
                            .stepSized(config.stepSize)
                            .coerceIn(0f, config.numStars.toFloat())

                    if (direction == LayoutDirection.Rtl)
                        newValue = config.numStars - newValue

                    onValueChange(newValue)
                    onRatingChanged(newValue)
                }
            }
            true
        }
    )
    {

        RatingStars(value = value, config = config)
    }

}



@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
private fun RatingBarPreview() {
    RatingBar()
}