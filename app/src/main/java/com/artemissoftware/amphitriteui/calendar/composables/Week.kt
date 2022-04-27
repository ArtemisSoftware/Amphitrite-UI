package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.calendar.models.CalendarDay
import com.artemissoftware.amphitriteui.calendar.models.DayOfWeek
import com.artemissoftware.amphitriteui.util.CalendarConstants.CELL_SIZE
import com.artemissoftware.amphitriteui.util.CalendarWeek


@Composable
fun Week(
    modifier: Modifier = Modifier,
//    month: CalendarMonth,
    week: CalendarWeek,
//    onDayClicked: (CalendarDay) -> Unit
) {
    //val (leftFillColor, rightFillColor) = getLeftRightWeekColors(week, month)

    Row(modifier = modifier) {

        val spaceModifiers = Modifier
            .weight(1f)
            .heightIn(max = CELL_SIZE)

//        Surface(
//            modifier = spaceModifiers,
//            color = leftFillColor
//        ) {
//            Spacer(Modifier.fillMaxHeight())
//        }

        for (day in week) {
            Day(
                day = day,
//                onDayClicked,
//                month
            )
        }

//        Surface(
//            modifier = spaceModifiers,
//            color = rightFillColor
//        ) {
//            Spacer(Modifier.fillMaxHeight())
//        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeekPreview() {

    Week(week = listOf(CalendarDay("2"), CalendarDay("3")))
}