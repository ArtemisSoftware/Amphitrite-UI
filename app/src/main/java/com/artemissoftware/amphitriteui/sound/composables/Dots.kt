package com.artemissoftware.amphitriteui.sound.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.ui.theme.Teal200

@Composable
fun Dots(modifier: Modifier){

    val dots = listOf(
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) }
    )

    val dys = dots.map { it.value }


    val travelDistance = with(LocalDensity.current) { 15.dp.toPx() }

    Row(
        modifier = modifier
    ) {
        dys.forEachIndexed { index, dy ->
            Box(
                modifier = Modifier
                    .size(25.dp)
//                    .graphicsLayer {
//                        translationY = -dy * travelDistance
//                    }
            ) {
                Dot()
            }

            if (index != dys.size - 1) {
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Dot(){

    Box(modifier = Modifier
        .size(40.dp)
        .background(color = Teal200, shape = CircleShape)
    )
}



@Preview(showBackground = true)
@Composable
private fun DotsPreview() {
    Dots(Modifier)
}