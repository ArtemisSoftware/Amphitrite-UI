package com.artemissoftware.amphitriteui.sound

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.sound.composables.Dots
import com.artemissoftware.amphitriteui.sound.composables.Wave

@Composable
fun SoundScreen() {


    val animationSpec = infiniteRepeatable<Float>(
        animation = tween(4000, easing = FastOutLinearInEasing),
        repeatMode = RepeatMode.Restart
    )



    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Dots(modifier = Modifier.align(CenterHorizontally))

        Spacer(modifier = Modifier.height(100.dp))
        
        Wave(
            modifier = Modifier.align(CenterHorizontally),
            animationSpecification = animationSpec)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SoundScreen()
}