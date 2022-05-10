package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.calendar.models.CalendarDay
import com.artemissoftware.amphitriteui.calendar.models.CalendarMonth
import com.artemissoftware.amphitriteui.calendar.models.DayOfWeek
import com.artemissoftware.amphitriteui.util.CalendarYear

@Composable
fun Calendar(
    calendarYear: CalendarYear,
    onDayClicked: (CalendarDay, CalendarMonth) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {

        item {
            Spacer(Modifier.height(32.dp))
        }

        for (month in calendarYear) {

            itemsCalendarMonth(
                month = month,
                onDayClicked = onDayClicked
            )

            item {
                Spacer(Modifier.height(32.dp))
            }
        }

//        item {
//            Spacer(modifier = Modifier.wrapContentHeight())
//        }
    }
}


private fun LazyListScope.itemsCalendarMonth(
    month: CalendarMonth,
    onDayClicked: (CalendarDay, CalendarMonth) -> Unit
) {

    item {
        MonthHeader(
            modifier = Modifier.padding(horizontal = 32.dp),
            month = month.name,
            year = month.year
        )
    }

    val contentModifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)


    item {
        DaysOfWeek(modifier = contentModifier)
    }

    month.weeks.value.forEachIndexed { index, week ->
        item(key = "${month.year}/${month.monthNumber}/${index + 1}") {
            Week(
                modifier = contentModifier,
                week = week,
                month = month,
                onDayClicked = { day ->
                    onDayClicked(day, month)
                }
            )
        }

        item {
            Spacer(Modifier.height(8.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CalendarPreview() {

    Calendar(calendarYear = CalendarMonth.getMock_OneMonth(), onDayClicked = {_,_->})
}
