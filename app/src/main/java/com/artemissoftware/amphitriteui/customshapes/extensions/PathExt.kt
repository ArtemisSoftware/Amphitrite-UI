package com.artemissoftware.amphitriteui.customshapes.extensions

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path

fun Path.heartPath(size: Size): Path {

    val width: Float = size.width
    val height: Float = size.height

    // Starting point
    moveTo(width / 2, height / 5)

    // Upper left path
    cubicTo(
        5 * width / 14, 0f,
        0f, height / 15,
        width / 28, 2 * height / 5
    )

    // Lower left path
    cubicTo(
        width / 14, 2 * height / 3,
        3 * width / 7, 5 * height / 6,
        width / 2, height
    )

    // Lower right path
    cubicTo(
        4 * width / 7, 5 * height / 6,
        13 * width / 14, 2 * height / 3,
        27 * width / 28, 2 * height / 5
    )

    // Upper right path
    cubicTo(
        width, height / 15,
        9 * width / 14, 0f,
        width / 2, height / 5
    )
    return this
}