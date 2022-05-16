package com.artemissoftware.amphitriteui.animation.flip

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@ExperimentalMaterialApi
@Composable
fun FlipCard(modifier: Modifier) {
    Card(
        onClick = {
//            onClick(flipCard)
        },
        modifier = modifier
            .fillMaxSize()
            /*.graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 12f * density
            }*/,
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
//        if (rotation.value <= 90f) {
//            Box(
//                Modifier.fillMaxSize()
//            ) {
//                forward()
//            }
//        } else {
//            Box(
//                Modifier
//                    .fillMaxSize()
//                    .graphicsLayer {
//                        rotationY = 180f
//                    }
//            ) {
//                previous()
//            }
//        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FlipCard(modifier = Modifier)
}