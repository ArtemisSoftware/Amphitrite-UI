package com.artemissoftware.amphitriteui.calendar

import androidx.lifecycle.ViewModel
import com.artemissoftware.amphitriteui.calendar.models.DaySelected
import com.artemissoftware.amphitriteui.calendar.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository
): ViewModel() {

//    val datesSelected = calendarRepository.datesSelected
    val datesSelectedState = DatesSelectedState(calendarRepository.getCalendarYear())


    val calendarYear = calendarRepository.getCalendarYear()

    fun onDaySelected(daySelected: DaySelected) {

        datesSelectedState.daySelected(daySelected)
//        viewModelScope.launch {
//            datesRepository.onDaySelected(daySelected)
//        }
    }
//
//
//    suspend fun onDaySelected(daySelected: DaySelected) = withContext(defaultDispatcher) {
//        datesSelected.daySelected(daySelected)
//    }
}