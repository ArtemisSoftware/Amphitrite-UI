package com.artemissoftware.amphitriteui.animation.flyinghearts

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.animation.flyinghearts.composables.FlyingHeart

@Composable
fun FlyingHeartScreen() {

    val heartCount = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {

        repeat(heartCount.value) {

            FlyingHeart(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 36.dp),
                horizontalPadding = 24,
                bottomMargin = 110,
            )
        }


        Button(
            onClick = {
                heartCount.value++
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            Text(
                text = "Fly my little heart",
                color = Color.White
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    FlyingHeartScreen()
}