package com.artemissoftware.amphitriteui.ratingbar

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.extensions.addStar
import com.artemissoftware.amphitriteui.ratingbar.models.FractionalRectangleShape
import com.artemissoftware.amphitriteui.ratingbar.models.RatingBarStyle
import com.artemissoftware.amphitriteui.util.RatingStarConfig


@Composable
fun RatingStar(
    @FloatRange(from = 0.0, to = 1.0) fraction: Float,
    config: RatingStarConfig,
    starSize: Dp = 100.dp,
    modifier: Modifier = Modifier,
) {
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

    Box(modifier = modifier) {
        FilledStar(fraction = fraction, starSize = starSize, config = config, isRtl = isRtl)
        EmptyStar(fraction = fraction, starSize = starSize, config = config, isRtl = isRtl)
    }
}

@Composable
private fun FilledStar(
    fraction: Float,
    starSize: Dp = 100.dp,
    config: RatingStarConfig,
    isRtl: Boolean
) = Canvas(
    modifier = Modifier
        .size(size = starSize)
        .clip(
            if (isRtl)
                rtlFilledStarFractionalShape(fraction = fraction)
            else
                FractionalRectangleShape(0f, fraction)
        )
) {
    val path = Path().addStar(size)

    drawPath(path, color = config.activeColor, style = Fill) // Filled Star
    drawPath(path, color = config.activeColor, style = Stroke(width = RatingStarConfig.starStrokeWidth)) // Border
}



@Composable
private fun EmptyStar(
    fraction: Float,
    starSize: Dp = 100.dp,
    config: RatingStarConfig,
    isRtl: Boolean
) = Canvas(
    modifier = Modifier
        .size(size = starSize)
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
        drawPath(path, color = Color.Gray, style = Stroke(width = RatingStarConfig.starStrokeWidth))
}





private fun rtlEmptyStarFractionalShape(fraction: Float): FractionalRectangleShape {
    return if (fraction == 1f || fraction == 0f)
        FractionalRectangleShape(fraction, 1f)
    else FractionalRectangleShape(0f, 1f - fraction)
}

private fun rtlFilledStarFractionalShape(fraction: Float): FractionalRectangleShape {
    return if (fraction == 0f || fraction == 1f)
        FractionalRectangleShape(0f, fraction)
    else FractionalRectangleShape(1f - fraction, 1f)
}


@Preview(showBackground = true)
@Composable
private fun FilledStarPreview() {
    FilledStar(fraction = 1F, config = RatingStarConfig(), isRtl = true)

}

@Preview(showBackground = true)
@Composable
private fun EmptyStarPreview() {
    EmptyStar(fraction = 0.5F, config = RatingStarConfig(), isRtl = true)
}

@Preview(showBackground = true)
@Composable
private fun RatingStarPreview() {

    Column {

        val highLighted = RatingStarConfig().style(RatingBarStyle.HighLighted)

        EmptyStar(fraction = 0F, config = highLighted, isRtl = true)
        FilledStar(fraction = 1F, config = RatingStarConfig(), isRtl = true)
        EmptyStar(fraction = 0F, config = RatingStarConfig(), isRtl = true)
        RatingStar(fraction = 0.3F, config = RatingStarConfig())
    }


}