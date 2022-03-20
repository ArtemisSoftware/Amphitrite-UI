package com.artemissoftware.amphitriteui.sound.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.Teal200

@Composable
fun Wave(modifier: Modifier){

    val waves = listOf(
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) }
    )

    val wavesDys = waves.map { it.value }

    Box(
        modifier = modifier
    ) {
        wavesDys.forEach { dy ->
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .align(alignment = Alignment.Center)
                    .graphicsLayer {
                        scaleX = dy * 4 + 1
                        scaleY = dy * 4 + 1
                        alpha = 1 - dy
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Teal200, shape = CircleShape)
                )
            }
        }

        Box(
            modifier = Modifier
                .size(50.dp)
                .align(alignment = Alignment.Center)
                .background(color = Teal200, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_mic_24),
                contentDescription = "Audio",
                tint = Color.Black,
                modifier = Modifier
                    .size(32.dp)
                    .align(alignment = Alignment.Center)
            )
        }
    }



}

@Preview(showBackground = true)
@Composable
private fun WavePreview() {
    Wave(Modifier)
}