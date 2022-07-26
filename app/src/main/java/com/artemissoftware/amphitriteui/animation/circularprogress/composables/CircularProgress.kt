package com.artemissoftware.amphitriteui.animation.circularprogress.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgress(
    modifier: Modifier,
    sweepAngle: Float = 210F
) {

    Canvas(
        modifier = modifier
    ) {
        drawArc(
            color = Color.Green,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(100f, cap = StrokeCap.Round)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CircularProgress(modifier = Modifier.size(250.dp).padding(8.dp))
}