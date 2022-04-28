package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Circle(color: Color) {
    Canvas(Modifier.fillMaxSize()) {
        drawCircle(color)
    }
}