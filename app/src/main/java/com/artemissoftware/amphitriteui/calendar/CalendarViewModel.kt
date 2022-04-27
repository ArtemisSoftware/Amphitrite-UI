package com.artemissoftware.amphitriteui.calendar

import androidx.lifecycle.ViewModel
import com.artemissoftware.amphitriteui.calendar.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository
): ViewModel() {

//    val datesSelected = calendarRepository.datesSelected
//    val datesSelected = DatesSelectedState(datesLocalDataSource.year2021)


    val calendarYear = calendarRepository.getCalendarYear()

//    fun onDaySelected(daySelected: DaySelected) {
//        viewModelScope.launch {
//            datesRepository.onDaySelected(daySelected)
//        }
//    }
//
//
//    suspend fun onDaySelected(daySelected: DaySelected) = withContext(defaultDispatcher) {
//        datesSelected.daySelected(daySelected)
//    }
}