package com.artemissoftware.amphitriteui.sound

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
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SoundScreen()
}