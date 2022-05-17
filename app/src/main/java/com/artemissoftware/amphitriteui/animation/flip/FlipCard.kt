package com.artemissoftware.amphitriteui.animation.flip

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.animation.flip.composables.BackSide
import com.artemissoftware.amphitriteui.animation.flip.composables.FlipCardSides
import com.artemissoftware.amphitriteui.animation.flip.composables.FrontSide
import com.artemissoftware.amphitriteui.animation.flip.models.FlipSides


@ExperimentalMaterialApi
@Composable
fun FlipCard (modifier: Modifier = Modifier){

    var flipSides by remember { mutableStateOf(FlipSides.FRONT) }

    val rotation = animateFloatAsState(
        targetValue = flipSides.angle,
        animationSpec = tween(
            durationMillis = 2000,
            easing = FastOutSlowInEasing
        )
    )

    Card(
        onClick = {
            flipSides = flipSides.next
        },
        modifier = modifier

        .graphicsLayer {
            rotationY = rotation.value
            cameraDistance = 12f * density
        },
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        FlipCardSides (
            rotation = rotation,
            front = { FrontSide() },
            back = { BackSide() }
        )
    }
}




@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FlipCard(modifier = Modifier)
}
