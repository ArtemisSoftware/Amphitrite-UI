package com.artemissoftware.amphitriteui.showcase.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates

data class ShowCase(
    val index: Int,
    val coordinate: LayoutCoordinates,
    val title: String,
    val subTitle: String,
    val titleColor: Color = Color.White,
    val subTitleColor: Color = Color.White
)