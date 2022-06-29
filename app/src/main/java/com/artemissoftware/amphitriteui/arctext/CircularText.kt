package com.artemissoftware.amphitriteui.arctext

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun CircularText(text: String) {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val radius = min(size.width, size.height) / 2
        val padding = 20

        drawCircle(
            color = Color.Black,
            radius = radius - padding,
            style = Stroke(
                width = 5f
            )
        )

        val c1 = Offset(x = radius / 2, y = center.y - radius)

        drawCircle(
            color = Color.Red,
            center = c1,
            radius = 20f
        )

        val c2 = Offset(x = size.width - radius / 2, y = center.y - radius)

        drawCircle(
            color = Color.Red,
            center = c2,
            radius = 20f
        )

        val path = Path().apply {
            moveTo(padding.toFloat() * 6, center.y)
            //lineTo(size.width - padding, center.y)
            cubicTo(
                x1 = c1.x, y1 = c1.y,
                x2 = c2.x, y2 = c2.y,
                x3 = size.width - padding * 6, y3 = center.y
            )
        }

        drawPath(
            path = path,
            color = Color.Black,
            style = Stroke(
                width = 5f
            )
        )

        this.drawContext.canvas.nativeCanvas.apply {

            drawTextOnPath(
                text,
                path.asAndroidPath(),
                0f,
                0f,
                Paint().apply {
                    this.color = android.graphics.Color.BLACK
                    this.textSize = 65f
                    this.textAlign = Paint.Align.CENTER
                }

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        CircularText(text = "Artemis")
    }
}