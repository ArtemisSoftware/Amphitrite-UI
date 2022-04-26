package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.calendar.CalendarScreen
import com.artemissoftware.amphitriteui.calendar.models.CalendarDay
import com.artemissoftware.amphitriteui.calendar.models.DayOfWeek

@Composable
fun Day(name: String) {
    DayContainer {
        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = name,
            style = MaterialTheme.typography.caption.copy(Color.Black.copy(alpha = 0.6f))
        )
    }
}


@Composable
fun Day(
    day: CalendarDay,
//    onDayClicked: (CalendarDay) -> Unit,
//    month: CalendarMonth,
    modifier: Modifier = Modifier
) {

//    val enabled = day.status != DaySelectedStatus.NonClickable

    DayContainer(
        modifier = modifier.semantics {
//            if (enabled) text = AnnotatedString("${month.name} ${day.value} ${month.year}")
//            dayStatusProperty = day.status
        },
//        selected = day.status != DaySelectedStatus.NoSelected,
//        onClick = { onDayClicked(day) },
//        onClickEnabled = enabled,
//        backgroundColor = day.status.color(MaterialTheme.colors),
//        onClickLabel = stringResource(id = R.string.click_label_select)
    ) {
//        DayStatusContainer(status = day.status) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                    // Parent will handle semantics
                    .clearAndSetSemantics {},
                text = day.value,
                style = MaterialTheme.typography.body1.copy(color = Color.Black)
            )
//        }
    }
}


@Composable
fun DaysOfWeek(modifier: Modifier = Modifier) {
    Row(modifier = modifier.clearAndSetSemantics { }) {
        for (day in DayOfWeek.values()) {
            Day(name = day.name.take(1))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DayPreview() {
    Day("2")
}

@Preview(showBackground = true)
@Composable
private fun DaysOfWeekPreview() {
    DaysOfWeek()
}