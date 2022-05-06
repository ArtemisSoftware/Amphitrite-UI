package com.artemissoftware.amphitriteui.calendar.models

enum class DaySelectedStatus {
    NoSelected,
    Selected,
    NonClickable,
    FirstDay,
//    LastDay,
    FirstLastDay
    ;

    companion object {

        fun isMarked(selectedStatus: DaySelectedStatus): Boolean {
            return when (selectedStatus) {
                Selected -> true
                FirstDay -> true
//                LastDay -> true
                FirstLastDay -> true
                else -> false
            }

        }
    }
}