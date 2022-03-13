package com.artemissoftware.amphitriteui.util

import androidx.compose.ui.graphics.Color

object Constants {

    const val VIDEO_URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"

    val SHIMMER_COLORS = listOf(
        Color.LightGray.copy(0.9f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.9f)
    )


    const val ExpandAnimationDuration = 3000//300
    const val CollapseAnimationDuration = 3000
    const val FadeInAnimationDuration = 3000//300
    const val FadeOutAnimationDuration = 3000
}