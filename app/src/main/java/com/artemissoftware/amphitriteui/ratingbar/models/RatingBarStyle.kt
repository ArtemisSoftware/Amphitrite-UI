package com.artemissoftware.amphitriteui.ratingbar.models

sealed class RatingBarStyle {
    object Normal : RatingBarStyle()
    object HighLighted : RatingBarStyle()
}
