package com.artemissoftware.amphitriteui.util

import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.calendar.models.CalendarDay
import com.artemissoftware.amphitriteui.calendar.models.CalendarMonth

object CalendarConstants {

    val CELL_SIZE = 48.dp

}

typealias CalendarWeek = List<CalendarDay>
typealias CalendarYear = List<CalendarMonth>