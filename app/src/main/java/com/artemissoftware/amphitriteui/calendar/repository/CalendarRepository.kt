package com.artemissoftware.amphitriteui.calendar.repository

import com.artemissoftware.amphitriteui.calendar.models.CalendarMonth
import com.artemissoftware.amphitriteui.calendar.models.DayOfWeek
import com.artemissoftware.amphitriteui.util.CalendarYear
import javax.inject.Inject

class CalendarRepository @Inject constructor(){

    fun getCalendarYear(): CalendarYear {
        val january2021 = CalendarMonth(
            name = "January",
            year = "2021",
            numDays = 31,
            monthNumber = 1,
            startDayOfWeek = DayOfWeek.Friday
        )
        val february2021 = CalendarMonth(
            name = "February",
            year = "2021",
            numDays = 28,
            monthNumber = 2,
            startDayOfWeek = DayOfWeek.Monday
        )
        val march2021 = CalendarMonth(
            name = "March",
            year = "2021",
            numDays = 31,
            monthNumber = 3,
            startDayOfWeek = DayOfWeek.Monday
        )
        val april2021 = CalendarMonth(
            name = "April",
            year = "2021",
            numDays = 30,
            monthNumber = 4,
            startDayOfWeek = DayOfWeek.Thursday
        )
        val may2021 = CalendarMonth(
            name = "May",
            year = "2021",
            numDays = 31,
            monthNumber = 5,
            startDayOfWeek = DayOfWeek.Tuesday
        )
        val june2021 = CalendarMonth(
            name = "June",
            year = "2021",
            numDays = 30,
            monthNumber = 6,
            startDayOfWeek = DayOfWeek.Tuesday
        )
        val july2021 = CalendarMonth(
            name = "July",
            year = "2021",
            numDays = 31,
            monthNumber = 7,
            startDayOfWeek = DayOfWeek.Thursday
        )
        val august2021 = CalendarMonth(
            name = "August",
            year = "2021",
            numDays = 31,
            monthNumber = 8,
            startDayOfWeek = DayOfWeek.Sunday
        )
        val september2021 = CalendarMonth(
            name = "September",
            year = "2021",
            numDays = 30,
            monthNumber = 9,
            startDayOfWeek = DayOfWeek.Wednesday
        )
        val october2021 = CalendarMonth(
            name = "October",
            year = "2021",
            numDays = 31,
            monthNumber = 10,
            startDayOfWeek = DayOfWeek.Friday
        )
        val november2021 = CalendarMonth(
            name = "November",
            year = "2021",
            numDays = 30,
            monthNumber = 11,
            startDayOfWeek = DayOfWeek.Monday
        )
        val december2021 = CalendarMonth(
            name = "December",
            year = "2021",
            numDays = 31,
            monthNumber = 12,
            startDayOfWeek = DayOfWeek.Wednesday
        )
        val year2021: CalendarYear = listOf(
            january2021,
//            february2021,
//            march2021,
//            april2021,
//            may2021,
//            june2021,
//            july2021,
//            august2021,
//            september2021,
//            october2021,
//            november2021,
//            december2021
        )

        return year2021
    }

}