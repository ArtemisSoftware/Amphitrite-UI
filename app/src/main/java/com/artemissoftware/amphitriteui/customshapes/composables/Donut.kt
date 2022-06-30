package com.artemissoftware.amphitriteui.customshapes.composables

import android.graphics.ComposePathEffect
import android.graphics.CornerPathEffect
import android.graphics.DiscretePathEffect
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.artemissoftware.amphitriteui.arctext.CircularText
import kotlin.random.Random

@Composable
fun Donut() {

    val baseColor = "#eb768b".toColorInt()
    val icingColor = "#ffdecd".toColorInt()

    Canvas(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

//        drawCircle(
//            color = Color(0xffeb768b),
//            radius = size.width / 2.5F
//        )



        //base

        val path = Path().apply {
            this.addOval(Rect(center = center, radius = size.width / 2.5f))
        }

        drawPath(path, color = Color(0xffeb768b))

        //layer de frosting

        drawContext.canvas.nativeCanvas.apply {

            drawCircle(
                center.x,
                center.y,
                (size.width / 2.5f) - 20f,
                android.graphics.Paint().apply {
                    this.color = icingColor
                    pathEffect = ComposePathEffect(
                        CornerPathEffect(100F),
                        DiscretePathEffect(60F, 15F)
                    )
                }
            )
        }

        //toppings

        //middle

        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                center.x, center.y,
                100f,
                Paint().apply {
                    color = android.graphics.Color.WHITE
                    setShadowLayer(
                        100f, 0f, -30f, baseColor
                    )
                }
            )
        }

        for(x in 1..10){

            val position = Random.nextInt(-1000, 1000)

            drawArc(
                color = Color.Blue,
                startAngle = 30f,
                sweepAngle = 300f,
                useCenter = false,
                style = Stroke(width = 6f, cap = StrokeCap.Round),
                topLeft = Offset(center.x - position ,center.y - position),
                size = Size(size.width / 2, size.height / 2),
            )
        }



    }
}


private fun DrawScope.drawSprinkles(path: Path, radius : Float) {

    val angle = Random.nextInt(360)
    val diff = Random.nextInt(-1000,1000)

    clipPath(path) {
        drawArc(
            color = randomColors[/*Random.nextInt(randomColors.size-1)*/0],
            startAngle = angle.toFloat(),
            sweepAngle = Random.nextInt(3 ,8).toFloat(),
            useCenter = false,
            style = Stroke(
                Random.nextInt(5 ,10).toFloat(),
                cap = StrokeCap.Round
            ),
            topLeft = Offset(center.x - diff ,center.y - diff),
            size = Size(radius,radius),
        )
    }
}


private val randomColors = listOf(
    Color(0xff4998df),
    Color(0xffe40542),
    Color(0xff222f5b),
    Color(0xffff4d00),
    Color(0xff00ff00),
    Color(0xffe38117),
    Color(0xffa858be),
    Color(0xff5f9a69),
    Color(0xff008080),
    Color(0xffd59cc2),
)



@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Donut()
}