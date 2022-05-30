package com.artemissoftware.amphitriteui.speedometer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview
@Composable
fun SpeedoMeterScreen() {

    var targetValue by remember { mutableStateOf( getRandomTarget()) }
    val progress = remember { Animatable(initialValue = 0f) }
    val scope = rememberCoroutineScope()

    val intValue = targetValue * 55

    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpeedoMeter(progress = progress.value.toInt())

        Button(
            onClick = {

                targetValue = getRandomTarget()

                scope.launch {
                    progress.animateTo(
                        targetValue = intValue,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = FastOutLinearInEasing
                        )
                    )
                }
            }
        ) {
            Text(text = "Next speed ${intValue.toInt()} ")
        }

    }
}


private fun getRandomTarget() = (0..100).random().toFloat() / 100