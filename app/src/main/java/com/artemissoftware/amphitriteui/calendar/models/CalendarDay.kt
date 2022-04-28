package com.artemissoftware.amphitriteui.calendar.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CalendarDay(
    val value: String,
    status: DaySelectedStatus
) {
    var status by mutableStateOf(status)
}
