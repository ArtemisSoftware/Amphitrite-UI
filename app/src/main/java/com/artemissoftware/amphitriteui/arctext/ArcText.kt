package com.artemissoftware.amphitriteui.arctext

import android.graphics.Path
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import android.graphics.RectF
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.R

@Composable
fun ArcText(text: String) {

    val paint = Paint().asFrameworkPaint()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 50.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 50.dp)
        ) {
            paint.apply {
                isAntiAlias = true
                textSize = 65f
                typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            }

            drawIntoCanvas {
                val path = Path()
                path.addArc(RectF(0f, 250f, 500f, 750f), 180f, 180f)
                it.nativeCanvas.drawTextOnPath(text, path, 0f, 0f, paint)
            }
        }

        Image(
            painter = painterResource(id = R.drawable.artemis_4),
            contentDescription = "Image",
            modifier = Modifier
                .padding(start = 90.dp, top = 120.dp)
                .size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    ArcText(text = "Artemis is hunting all alone")
}