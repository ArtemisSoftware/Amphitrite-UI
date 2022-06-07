package com.artemissoftware.amphitriteui.animation.scaling

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.artemissoftware.amphitriteui.animation.scaling.composables.ImageScale
import kotlinx.coroutines.launch

@Composable
fun ScalingScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        ImageScale(modifier = Modifier)
        Spacer(modifier = Modifier.height(16.dp))
        TranslationAnimation_1()
        TranslationAnimation_2()

    }



}

@Preview(showBackground = true)
@Composable
fun TranslationAnimation_1() {


    val animatableSize = remember { Animatable(Size.Zero, Size.VectorConverter) }
    val (containerSize, setContainerSize) = remember { mutableStateOf<Size?>(null) }
    val (imageSize, setImageSize) = remember { mutableStateOf<Size?>(null) }
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()


    val animateModifier = Modifier
        .then(
            if (animatableSize.value != Size.Zero) {
                animatableSize.value.run {
                    Modifier.size(
                        width = with(density) { width.toDp() },
                        height = with(density) { height.toDp() }
                    )
                }
            } else {
                Modifier
            }
        )
        .onSizeChanged { intSize ->
            if (imageSize != null) return@onSizeChanged
            val size = intSize.toSize()
            setImageSize(size)
            scope.launch {
                animatableSize.snapTo(size)
            }
        }



    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                scope.launch {
                    if (imageSize == null || containerSize == null) return@launch
                    val targetSize = if (animatableSize.value == imageSize) containerSize else imageSize
                    animatableSize.animateTo(
                        targetSize,
                        animationSpec = tween(1000)
                    )
                }
            }
        ) {
            Text(text = "Animate")
        }

        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(200.dp)
                .background(Color.LightGray)
                .onSizeChanged { size ->
                    setContainerSize(size.toSize())
                }
        ) {
            ImageScale(modifier = animateModifier.align(Alignment.Center))
        }


    }


}

@Preview(showBackground = true)
@Composable
private fun TranslationAnimation_2() {

    var isLarge by remember {  mutableStateOf(true) }
    val large = Size(/*250F, 400F*/ 250F, 250F)
    val small = Size(/*350F, 150F*/100F, 100F)

    val size by animateSizeAsState(
        targetValue = if(isLarge) large else small,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { isLarge = !isLarge}
        ) {
            Text(text = "Transform to " + if(isLarge) "small" else "large")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(250.dp)
                .background(Color.LightGray)
        ) {

            ImageScale(modifier = Modifier
                .size(size.width.dp, size.height.dp)
                .align(Alignment.Center))
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ScalingScreen()
}