package com.artemissoftware.amphitriteui.animation.trianglespin

import androidx.compose.foundation.shape.GenericShape

val TriangleShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)
}