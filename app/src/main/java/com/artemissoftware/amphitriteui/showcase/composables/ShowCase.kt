package com.artemissoftware.amphitriteui.showcase.composables

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.showcase.models.ShowCaseInfo
import com.artemissoftware.amphitriteui.util.SpotlightUtil.getOutCircleCenter
import com.artemissoftware.amphitriteui.util.SpotlightUtil.getOuterRadius
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue
import kotlin.math.max


@Composable
fun ShowCaseView(
    targets: SnapshotStateMap<String, ShowCaseInfo>,
    backgroundColor: Color = Color.Black,
    onShowCaseCompleted: () -> Unit
) {
    val uniqueTargets = targets.values.sortedBy { it.index }
    var currentTargetIndex by remember { mutableStateOf(0) }
    val currentTarget = if (uniqueTargets.isNotEmpty() && currentTargetIndex < uniqueTargets.size) uniqueTargets[currentTargetIndex] else null

    currentTarget?.let {
        TargetContent(
            target = it,
            backgroundColor = backgroundColor,
            onShowCaseCompleted = {
                if (++currentTargetIndex >= uniqueTargets.size) {
                    onShowCaseCompleted()
                }
            }
        )
    }
}


@Composable
private fun TargetContent(
    target: ShowCaseInfo,
    backgroundColor: Color,
    onShowCaseCompleted: () -> Unit
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp
    val targetCords = target.coordinate
    val targetRect = targetCords.boundsInRoot()

    val topArea = 88.dp

    var textCoordinate: LayoutCoordinates? by remember { mutableStateOf(null) }
    val yOffset = with(LocalDensity.current) { targetCords.positionInRoot().y.toDp() }
    val maxDimension = max(targetCords.size.width.absoluteValue, targetCords.size.height.absoluteValue)
    val targetRadius = maxDimension / 2f + 40f


    var outerOffset by remember { mutableStateOf(Offset(0f, 0f)) }
    var outerRadius by remember { mutableStateOf(0f) }

    textCoordinate?.let { textCoordinates ->
        val textRect = textCoordinates.boundsInRoot()
        val textHeight = textCoordinates.size.height
        val isInGutter = topArea > yOffset || yOffset > screenHeight.dp.minus(topArea)

        outerOffset = getOutCircleCenter(targetRect, textRect, targetRadius, textHeight, isInGutter)
        outerRadius = getOuterRadius(textRect, targetRect) + targetRadius
    }



    val outerAnimatable = remember { Animatable(0.6f) }

    LaunchedEffect(target) {
        outerAnimatable.snapTo(0.6f)
        outerAnimatable.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
    }



    val animatables = listOf(
        remember { Animatable(0f) },
        //remember { Animatable(0f) }
    )

    val animationSpec = infiniteRepeatable<Float>(
        animation = tween(durationMillis = 2000, easing = FastOutLinearInEasing),
        repeatMode = RepeatMode.Restart
    )

    animatables.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index + 1000L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = animationSpec
            )
        }
    }

    val ripples = animatables.map { it.value }

    Box {

        Spotlight(
            showCaseInfo = target,
            onShowCaseCompleted = onShowCaseCompleted,
            targetRect = targetRect,
            targetRadius = targetRadius,
            backgroundColor = backgroundColor,
            outerOffset = outerOffset,
            outerRadius = outerRadius,
            outerAnimatable = outerAnimatable,
            ripples = ripples,
            maxDimension = maxDimension
        )

        ShowCaseText(
            currentTarget = target,
            boundsInParent = targetRect,
            targetRadius = targetRadius,
            onGloballyPositioned = {
                textCoordinate = it
            }
        )
    }
}

@Composable
private fun Spotlight(
    showCaseInfo: ShowCaseInfo,
    onShowCaseCompleted: () -> Unit,
    targetRect: Rect,
    backgroundColor: Color,
    outerOffset: Offset,
    outerRadius: Float,
    targetRadius: Float,
    outerAnimatable: Animatable<Float, AnimationVector1D>,
    ripples: List<Float>,
    maxDimension: Int
) {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(showCaseInfo) {
                detectTapGestures { tapOffset ->
                    if (targetRect.contains(tapOffset)) {
                        onShowCaseCompleted()
                    }
                }
            }
            .graphicsLayer(alpha = 0.99f)
    ) {
            drawCircle(
                color = backgroundColor,
                center = outerOffset,
                radius = outerRadius * outerAnimatable.value,
                alpha = 0.9f
            )

            ripples.forEach { ripple ->
                drawCircle(
                    color = Color.White,
                    radius = maxDimension * ripple * 2f,
                    center = targetRect.center,
                    alpha = 1 - ripple
                )
            }

            drawCircle(
                color = Color.Transparent,
                radius = targetRadius,
                center = targetRect.center,
                blendMode = BlendMode.Clear
            )
    }
}

