package com.artemissoftware.amphitriteui.calendar

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.amphitriteui.calendar.composables.Calendar
import com.artemissoftware.amphitriteui.calendar.composables.CalendarTopAppBar
import com.artemissoftware.amphitriteui.calendar.models.CalendarMonth
import com.artemissoftware.amphitriteui.calendar.models.DaySelected

@Composable
fun CalendarScreen() {

    val calendarViewModel: CalendarViewModel = hiltViewModel()
    val calendarYear = calendarViewModel.calendarYear
    val selectedDates = ""

    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            CalendarTopAppBar(selectedDates = selectedDates)
        }
    ) {

        Calendar(
            calendarYear = CalendarMonth.getMock_MoreMonths(),
            onDayClicked = { calendarDay, calendarMonth ->
                calendarViewModel.onDaySelected(
                    DaySelected(
                        day = calendarDay.value.toInt(),
                        month = calendarMonth,
                        year = calendarYear
                    )
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CalendarScreen()
}