package com.artemissoftware.amphitriteui.animation.flip

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.ui.theme.ForwardColor
import com.artemissoftware.amphitriteui.ui.theme.PreviousColor

@ExperimentalMaterialApi
@Composable
fun FlipCard___(modifier: Modifier) {
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


@Composable
fun FlipAnimationCardContent (){

//    var flipCard by remember { mutableStateOf(FlipCard.Forward) }

//    FlipRotate(
//        flipCard = flipCard,
//        onClick = { flipCard = flipCard.next },
//        modifier = Modifier
//            .fillMaxWidth(.6f)
//            .aspectRatio(1f),
//        forward = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(ForwardColor),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_baseline_fast_forward_24),
//                    contentDescription = "Forward",
//                    modifier = Modifier.size(120.dp)
//                )
//            }
//        },
//        previous = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(PreviousColor),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_baseline_fast_rewind_24),
//                    contentDescription = "Previous",
//                    modifier = Modifier.size(120.dp)
//                )
//            }
//        }
//    )
}

@ExperimentalMaterialApi
@Composable
fun FlipCard (modifier: Modifier){
    val rotation = 90f
//    val rotation = animateFloatAsState(
//        targetValue = flipCard.angle,
//        animationSpec = tween(
//            durationMillis = 400,
//            easing = FastOutSlowInEasing
//        )
//    )

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
        FlipCardSides (
            rotation = rotation,
            previous = { FrontSide() },
            forward = { BackSide() }
        )
    }
}

@Composable
private fun FlipCardSides (
    rotation: Float,
    previous: @Composable () -> Unit = {},
    forward: @Composable () -> Unit = {}
){


     if (rotation/*.value*/ <= 90f) {
        Box(
            Modifier.fillMaxSize()
        ) {
            forward()
        }
    } else {
        Box(
            Modifier
                .fillMaxSize()
//                .graphicsLayer {
//                    rotationY = 180f
//                }
        ) {
            previous()
        }
    }
}

@Composable
private fun FrontSide (){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ForwardColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.artemis_6),
            contentDescription = "Forward",
            modifier = Modifier.size(120.dp)
        )
    }
}

@Composable
private fun BackSide (){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PreviousColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.artemis_4),
            contentDescription = "Forward",
            modifier = Modifier.size(120.dp)
        )
    }
}






@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FlipCard(modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
private fun FrontSidePreview() {
    FrontSide()
}

@Preview(showBackground = true)
@Composable
private fun BackSidePreview() {
    BackSide()
}