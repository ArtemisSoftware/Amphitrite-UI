package com.artemissoftware.amphitriteui.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

object SpotlightUtil {

    fun getOutCircleCenter(
        targetBound: Rect,
        textBound: Rect,
        targetRadius: Float,
        textHeight: Int,
        isInGutter: Boolean
    ): Offset {
        val outerCenterX: Float
        var outerCenterY: Float
        val onTop = targetBound.center.y - targetRadius - textHeight > 0
        val left = min(
            textBound.left,
            targetBound.left - targetRadius
        )
        val right = max(
            textBound.right,
            targetBound.right + targetRadius
        )
        val centerY = if (onTop) targetBound.center.y - targetRadius - textHeight
        else targetBound.center.y + targetRadius + textHeight

        outerCenterY = centerY
        outerCenterX = (left + right) / 2
        if (isInGutter) {
            outerCenterY = targetBound.center.y
        }

        return Offset(outerCenterX, outerCenterY)
    }

    fun getOuterRadius(
        textRect: Rect,
        targetRect: Rect
    ) : Float {
        val topLeftX = min(textRect.topLeft.x, targetRect.topLeft.x)
        val topLeftY = min(textRect.topLeft.y, targetRect.topLeft.y)
        val bottomRightX = max(textRect.bottomRight.x, targetRect.bottomRight.x)
        val bottomRightY = max(textRect.bottomRight.y, targetRect.bottomRight.y)
        val expandedBounds = Rect(topLeftX, topLeftY, bottomRightX, bottomRightY)
        val d = sqrt(expandedBounds.height.toDouble().pow(2.0) + expandedBounds.width.toDouble().pow(2.0)).toFloat()
        return (d / 2f)
    }
}