package com.artemissoftware.amphitriteui.util

import androidx.compose.ui.graphics.Color

object Constants {

    const val VIDEO_URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"

    val SHIMMER_COLORS = listOf(
        Color.LightGray.copy(0.9f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.9f)
    )


    const val ExpandAnimationDuration = 300
    const val CollapseAnimation = 300
    const val FadeInAnimation = 300
    const val FadeOutAnimation = 300
}