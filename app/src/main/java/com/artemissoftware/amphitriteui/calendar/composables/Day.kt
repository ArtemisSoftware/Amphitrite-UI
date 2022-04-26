package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.calendar.CalendarScreen
import com.artemissoftware.amphitriteui.calendar.models.DayOfWeek

@Composable
private fun Day(name: String) {
    DayContainer {
        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = name,
            style = MaterialTheme.typography.caption.copy(Color.Black.copy(alpha = 0.6f))
        )
    }
}


@Composable
private fun DaysOfWeek(modifier: Modifier = Modifier) {
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