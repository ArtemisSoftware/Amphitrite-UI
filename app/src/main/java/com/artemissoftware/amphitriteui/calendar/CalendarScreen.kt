package com.artemissoftware.amphitriteui.calendar

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.calendar.composables.CalendarTopAppBar

@Composable
fun CalendarScreen() {

    val selectedDates = ""

    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            CalendarTopAppBar(selectedDates = selectedDates)
        }
    ) {
        //Calendar(calendarYear, onDayClicked)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CalendarScreen()
}