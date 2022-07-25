package com.artemissoftware.amphitriteui.animation.clock.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ClockScreen() {

    val animationStart = remember { mutableStateOf(false) }
    val toggleState = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Clock(
            modifier = Modifier
                .aspectRatio(1.0f)
                .padding(64.dp),
            animationStart = animationStart
        )


        TextButton(
            onClick = {
                toggleState.value = !toggleState.value
                animationStart.value = toggleState.value
//                onToggle(toggleState.value)
            }
        ) {
            Text(fontSize = 32.sp, text = if (toggleState.value) "Stop" else "Start")
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    ClockScreen()
}