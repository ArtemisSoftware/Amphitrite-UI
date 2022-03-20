package com.artemissoftware.amphitriteui.ratingbar

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.artemissoftware.amphitriteui.extensions.addStar
import com.artemissoftware.amphitriteui.ratingbar.models.FractionalRectangleShape
import com.artemissoftware.amphitriteui.ratingbar.models.RatingBarStyle
import com.artemissoftware.amphitriteui.util.RatingStarConfig


private const val strokeWidth = 1f

@Composable
fun RatingStar(
    @FloatRange(from = 0.0, to = 1.0) fraction: Float,
    config: RatingStarConfig,
    modifier: Modifier = Modifier,
) {
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

    Box(modifier = modifier) {
        FilledStar(fraction, config.activeColor, isRtl)
        EmptyStar(fraction, config, isRtl)
    }
}

@Composable
private fun FilledStar(
    fraction: Float,
    activeColor: Color,
    isRtl: Boolean
) = Canvas(
    modifier = Modifier
        .fillMaxSize()
        .clip(
            if (isRtl)
                rtlFilledStarFractionalShape(fraction = fraction)
            else
                FractionalRectangleShape(0f, fraction)
        )
) {
    val path = Path().addStar(size)

    drawPath(path, color = activeColor, style = Fill) // Filled Star
    drawPath(path, color = activeColor, style = Stroke(width = strokeWidth)) // Border
}



@Composable
private fun EmptyStar(
    fraction: Float,
    config: RatingStarConfig,
    isRtl: Boolean
) = Canvas(
    modifier = Modifier
        .fillMaxSize()
        .clip(
            if (isRtl)
                rtlEmptyStarFractionalShape(fraction = fraction)
            else
                FractionalRectangleShape(fraction, 1f)
        )
) {
    val path = Path().addStar(size)
    if (config.style is RatingBarStyle.Normal)
        drawPath(path, color = config.inactiveColor, style = Fill)
    else
        drawPath(path, color = Color.Gray, style = Stroke(width = strokeWidth))
}





fun rtlEmptyStarFractionalShape(fraction: Float): FractionalRectangleShape {
    return if (fraction == 1f || fraction == 0f)
        FractionalRectangleShape(fraction, 1f)
    else FractionalRectangleShape(0f, 1f - fraction)
}

fun rtlFilledStarFractionalShape(fraction: Float): FractionalRectangleShape {
    return if (fraction == 0f || fraction == 1f)
        FractionalRectangleShape(0f, fraction)
    else FractionalRectangleShape(1f - fraction, 1f)
}



@Preview(showBackground = true)
@Composable
private fun StarsPreview() {

    Column {


        FilledStar(fraction = 1F, activeColor = RatingStarConfig.activeColor, isRtl = true)
        FilledStar(fraction = 0.5F, activeColor = RatingStarConfig.activeColor, isRtl = false)
        //EmptyStar(fraction = 1F, config = RatingStarConfig, isRtl = true)
    }

    //RatingBar()
}

@Preview(showBackground = true)
@Composable
private fun RatingStarPreview() {

    Column {


        RatingStar(fraction = 0.5F, config = RatingStarConfig)
    }

    //RatingBar()
}