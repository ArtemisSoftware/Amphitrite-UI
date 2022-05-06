package com.artemissoftware.amphitriteui.calendar.models

import com.artemissoftware.amphitriteui.util.CalendarYear
import java.util.*

data class DaySelected(
    val day: Int,
    val month: CalendarMonth,
    val year: CalendarYear
) {

    val calendarDay = lazy {
        month.getDay(day)
    }

    override fun toString(): String {
        val month = month.name
            .substring(0, 3)
            .replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
        return "$month $day"
    }

    operator fun compareTo(other: DaySelected): Int {
        if (day == other.day && month == other.month) return 0
        if (month == other.month) return day.compareTo(other.day)
        return (year.indexOf(month)).compareTo(
            year.indexOf(other.month)
        )
    }


    companion object{
        val EMPTY_DAY = DaySelected(-1, CalendarMonth("", "", 0, 0, DayOfWeek.Sunday), emptyList())
    }
}

