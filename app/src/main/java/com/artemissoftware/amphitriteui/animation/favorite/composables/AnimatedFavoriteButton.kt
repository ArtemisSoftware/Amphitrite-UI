package com.artemissoftware.amphitriteui.animation.favorite.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.animation.favorite.models.FavoriteButtonState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.artemissoftware.amphitriteui.R

//import androidx.compose.animation.core.AnimationConstants.Infinite
//import androidx.compose.animation.transition
//
//@Preview(showBackground = false)
//@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
//@Composable
//fun AnimatedFavoriteButton() {
//
//    var expanded by remember { mutableStateOf(false) }
//    val buttonState = remember { mutableStateOf(FavoriteButtonState.IDLE) }
//
//    Surface(
//        color = Color.White,
//
//    ) {
//        AnimatedContent(
//            targetState = expanded,
//            transitionSpec = {
//                fadeIn(animationSpec = tween(150, 150)) with
//                        fadeOut(animationSpec = tween(150)) using
//                        SizeTransform { initialSize, targetSize ->
//                            if (targetState) {
//                                keyframes {
//                                    // Expand horizontally first.
//                                    IntSize(targetSize.width, initialSize.height) at 2999
//                                    durationMillis = 3000
//                                }
//                            } else {
//                                keyframes {
//                                    // Shrink vertically first.
//                                    IntSize(initialSize.width, targetSize.height) at 150
//                                    durationMillis = 3000
//                                }
//                            }
//                        }
//            }
//        ) { targetExpanded ->
////            if (targetExpanded) {
////                ButtonContent()
////
////            } else {
////                FavoriteButton()
////            }
//            FavoriteButton(buttonState, onClick = {
//                expanded = !expanded
//                buttonState.value = if (expanded == true) {
//                    FavoriteButtonState.PRESSED
//                } else {
//                    FavoriteButtonState.IDLE
//                }
//            })
//        }
//    }
//
//
//
//
//
//
//
//}


@Preview(showBackground = false)
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentSizeTransform() {
    val time = 500

    val buttonState = remember { mutableStateOf(FavoriteButtonState.IDLE) }
    val buttonStateI = remember { mutableStateOf(FavoriteButtonState.IDLE) }
    val buttonStateP = remember { mutableStateOf(FavoriteButtonState.PRESSED) }

    Column {
        var expanded by remember {
            mutableStateOf(false)
        }

        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                if (targetState) {
                    expandFading(time) using expandSizing(time)
                } else {
                    shrinkFading(time) //using shrinkSizing(time)
                }

            }
        ) { targetExpanded ->
//            Image(
//                painter = painterResource(
//                    id = if (targetExpanded)
//                        R.drawable.artemis_6
//                    else
//                        R.drawable.artemis_4
//                ),
//                contentDescription = "",
//                modifier = Modifier.background(Color.Yellow)
//            )


            if (targetExpanded)
                FavoriteButton(buttonStateP, onClick = {})
                    else
                FavoriteButton(buttonStateI, onClick = {})

        }

        Button(onClick = {
            expanded = !expanded
            buttonState.value = if (expanded == true) {
                    FavoriteButtonState.PRESSED
                } else {
                    FavoriteButtonState.IDLE
                }
        }) {
            Text(if (expanded) "Hide" else "Show")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun shrinkSizing(time: Int) =
    SizeTransform { initialSize, targetSize ->
        keyframes {
            // Shrink to target height first
            IntSize(initialSize.width, targetSize.height) at time
            // Then shrink to target width
            durationMillis = time * 3
        }
    }

@OptIn(ExperimentalAnimationApi::class)
private fun shrinkFading(time: Int) =
    fadeIn(animationSpec = tween(time, time * 2)) with
            fadeOut(animationSpec = tween(time * 3))

@OptIn(ExperimentalAnimationApi::class)
private fun expandSizing(time: Int) =
    SizeTransform { initialSize, targetSize ->
        keyframes {
            // Expand to target width first
            IntSize(targetSize.width, initialSize.height) at time
            // Then expand to target height
            durationMillis = time * 3
        }
    }

@OptIn(ExperimentalAnimationApi::class)
private fun expandFading(time: Int) =
    fadeIn(animationSpec = tween(time * 3)) with
            fadeOut(animationSpec = tween(time))
