package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.calendar.models.CalendarDay

@Composable
fun MonthHeader(
    modifier: Modifier = Modifier,
    month: String,
    year: String
) {

    Row(modifier = modifier.clearAndSetSemantics { }) {
        Text(
            modifier = Modifier.weight(1f),
            text = month,
            style = MaterialTheme.typography.h6
        )
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = year,
            style = MaterialTheme.typography.caption
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MonthHeaderPreview() {

    MonthHeader(month = "January", year = "2022")
}