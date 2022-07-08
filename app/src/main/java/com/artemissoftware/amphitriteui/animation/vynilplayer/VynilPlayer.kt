package com.artemissoftware.amphitriteui.animation.vynilplayer

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.animation.vynilplayer.composables.AudioControl
import com.artemissoftware.amphitriteui.animation.vynilplayer.composables.VinylAnimation

@Composable
fun VynilPlayer() {

    val configuration = LocalConfiguration.current

    var playingState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.secondary,
                        MaterialTheme.colors.primary,
                    )
                )
            )
    ) {

        VinylAnimation(
            modifier = Modifier.align(TopCenter),
            isPlaying = playingState
        )

        AudioControl(
            modifier = Modifier
                .padding(72.dp)
                .size(72.dp)
                .align(
                    when (configuration.orientation) {
                        Configuration.ORIENTATION_LANDSCAPE -> CenterEnd
                        else -> BottomCenter
                    }
                ),
            isPlaying = playingState
        ) {
            playingState = !playingState
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    VynilPlayer()
}