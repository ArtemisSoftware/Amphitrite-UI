package com.artemissoftware.amphitriteui.speedometer

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpeedoMeter(
    progress: Int
) {
    val arcDegrees = 275
    val startArcAngle = 135f
    val startStepAngle = -45
    val numberOfMarkers = 55
    val degreesMarkerStep = arcDegrees / numberOfMarkers

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),

        onDraw = {

            drawIntoCanvas { canvas ->
                val w = drawContext.size.width
                val h = drawContext.size.height
                val centerOffset = Offset(w / 2f, h / 2f)
                val quarterOffset = Offset(w / 4f, h / 4f)

                val (mainColor, secondaryColor) = getArcColors(progress)

                val paint = Paint().apply {
                    color = mainColor
                }

                val centerArcSize = Size(w / 2f, h / 2f)

                val centerArcStroke = Stroke(20f, 0f, StrokeCap.Round)


                speedProgress(
                    baseColor = secondaryColor,
                    baseSweepAngle = arcDegrees.toFloat(),
                    fillColor = mainColor,
                    fillSweepAngle = (degreesMarkerStep * progress).toFloat(),
                    startAngle = startArcAngle,
                    topLeft = quarterOffset,
                    size = centerArcSize,
                    style = centerArcStroke
                )

                center(
                    color = mainColor,
                    centerOffset = centerOffset
                )


                for ((counter, degrees) in (startStepAngle..(startStepAngle + arcDegrees) step degreesMarkerStep).withIndex()) {

                    val lineEndX = 80f
                    paint.color = mainColor

                    val lineStartX = if (counter % 5 == 0) {
                        paint.strokeWidth = 3f
                        0f
                    } else {
                        paint.strokeWidth = 1f
                        lineEndX * .2f
                    }

                    canvas.save()
                    canvas.rotate(degrees.toFloat(), w / 2f, h / 2f)

                    canvas.drawLine(
                        Offset(lineStartX, h / 2f),
                        Offset(lineEndX, h / 2f),
                        paint
                    )

                    if (counter == progress) {
                        paint.color = Color.Black

                        pointer(
                            canvas = canvas,
                            width = w,
                            height = h,
                            paint = paint
                        )
                    }

                    canvas.restore()
                }


            }
        }
    )
}

private fun DrawScope.speedProgress(
    baseColor: Color,
    baseSweepAngle: Float,
    fillColor: Color,
    fillSweepAngle: Float,
    startAngle: Float,
    topLeft: Offset,
    size: Size,
    style: Stroke
) {


    drawArc(
        color = baseColor,
        startAngle = startAngle,
        sweepAngle = baseSweepAngle,
        useCenter = false,
        topLeft = topLeft,
        size = size,
        style = style
    )


    drawArc(
        color = fillColor,
        startAngle = startAngle,
        sweepAngle = fillSweepAngle,
        useCenter = false,
        topLeft = topLeft,
        size = size,
        style = style
    )

}

private fun DrawScope.center(
    color: Color,
    centerOffset: Offset
){

    drawCircle(
        color = color,
        radius = 50f,
        center = centerOffset
    )

    drawCircle(
        color = Color.White,
        radius = 25f,
        center = centerOffset
    )

    drawCircle(
        color = Color.Black,
        radius = 20f,
        center = centerOffset
    )
}


private fun pointer(canvas: Canvas, width: Float, height: Float, paint: Paint) {
    canvas.drawPath(
        path = Path().apply {
            moveTo(width / 2, (height / 2) - 5)
            lineTo(width / 2, (height / 2) + 5)
            lineTo(width / 4f, height / 2)
            lineTo(width / 2, (height / 2) - 5)
            close()
        },
        paint = paint
    )
}


private fun getArcColors(progress: Int): Pair<Color, Color> {
    return when {
        progress < 20 -> Color(0xFFD32F2F) to Color(0xFFFFCDD2)
        progress < 40 -> Color(0xFFF57C00) to Color(0xFFFFE0B2)
        else -> Color(0xFF388E3C) to Color(0xFFC8E6C9)
    }
}


@Preview(showBackground = false)
@Composable
private fun DefaultPreview() {

    SpeedoMeter(39)

}