package com.artemissoftware.amphitriteui.animation.vynilplayer.composables

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VinylAnimation(
    modifier: Modifier = Modifier,
    isPlaying: Boolean = false
) {
    // Allow resume on rotation
    var currentRotation by remember { mutableStateOf(0f) }

    val rotation = remember { Animatable(currentRotation) }

//    LaunchedEffect(isPlaying) {
//        if (isPlaying) {
//            // Infinite repeatable rotation when is playing
//            rotation.animateTo(
//                targetValue = currentRotation + 360f,
//                animationSpec = infiniteRepeatable(
//                    animation = tween(3000, easing = LinearEasing),
//                    repeatMode = RepeatMode.Restart
//                )
//            ) {
//                currentRotation = value
//            }
//        } else {
//            if (currentRotation > 0f) {
//                // Slow down rotation on pause
//                rotation.animateTo(
//                    targetValue = currentRotation + 50,
//                    animationSpec = tween(
//                        durationMillis = 1250,
//                        easing = LinearOutSlowInEasing
//                    )
//                ) {
//                    currentRotation = value
//                }
//            }
//        }
//    }

    Vinyl(modifier = modifier.padding(24.dp), rotationDegrees = rotation.value)
}