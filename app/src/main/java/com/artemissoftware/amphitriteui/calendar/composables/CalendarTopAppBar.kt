package com.artemissoftware.amphitriteui.calendar.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun CalendarTopAppBar(selectedDates: String) {
    Column {
//        Spacer(modifier = Modifier
//            .statusBarsHeight()
//            .fillMaxWidth()
//            .background(MaterialTheme.colors.primaryVariant)
//        )
        TopAppBar(
            title = {
                Text(
                    text = if (selectedDates.isEmpty()) "Select Dates" else selectedDates,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            elevation = 0.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalendarTopAppBar(selectedDates = "")
}