package com.artemissoftware.amphitriteui.scratchcard

import android.view.MotionEvent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@ExperimentalComposeUiApi
@Composable
fun ScratchCanvas(
    @DrawableRes overlayImage: Int,
    @DrawableRes baseImage: Int,
    movedOffset: Offset?,
    onMovedOffset: (Float, Float) -> Unit,
    currentPath: Path,
    currentPathThickness: Float,
    modifier: Modifier = Modifier,
){

    val overlayImage = ImageBitmap.imageResource(id = overlayImage)
    val baseImage = ImageBitmap.imageResource(id = baseImage)


    Canvas(
        modifier = modifier
            .size(220.dp)
            .clipToBounds()
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        currentPath.moveTo(it.x, it.y)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        onMovedOffset(it.x, it.y)
                    }
                }
                true
            },
    ) {
        val canvasWidth = size.width.toInt()
        val canvasHeight = size.height.toInt()
        val imageSize = IntSize(canvasWidth, canvasHeight)

        drawImage(
            image = overlayImage,
            dstSize = imageSize
        )

        movedOffset?.let {
            currentPath.addOval(oval = Rect(it, currentPathThickness))
        }

        clipPath(
            path = currentPath,
            clipOp = ClipOp.Intersect
        ) {
            drawImage(
                image = baseImage,
                dstSize = imageSize
            )
        }
    }

}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {



}