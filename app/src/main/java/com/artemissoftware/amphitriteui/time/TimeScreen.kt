package com.artemissoftware.amphitriteui.time

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import java.util.*

@Composable
fun TimeScreen() {

    val context = LocalContext.current

    var dateTime = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calender Date & Time Picker",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            onClick = {
                showDatePicker(context, dateTime)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Purple500)
                .padding(5.dp)
        ) {
            Text(text = "Select Date", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            onClick = {
                showTimePicker(context, dateTime)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Purple500)
                .padding(5.dp)
        ) {
            Text(text = "Select time", color = Color.White)
        }


        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            onClick = {
                showDateAndTimePicker(context, dateTime)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Purple500)
                .padding(5.dp)
        ) {
            Text(text = "Select date and time", color = Color.White)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = dateTime.value ?: "No Time Set")
    }
}

fun showDatePicker(context: Context, dateTime: MutableState<String?>) {

    val currentDateTime = Calendar.getInstance()
    val startYear = currentDateTime.get(Calendar.YEAR)
    val startMonth = currentDateTime.get(Calendar.MONTH)
    val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)

    val datePicker = DatePickerDialog(context, { _, year, month, day ->
        dateTime.value = formatDateTime(year, month, day)
        }, startYear, startMonth, startDay)

    datePicker.show()
}

fun showTimePicker(context: Context, dateTime: MutableState<String?>) {

    val currentDateTime = Calendar.getInstance()
    val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
    val startMinute = currentDateTime.get(Calendar.MINUTE)

    val timePicker = TimePickerDialog(context, { _, hour, minute ->
        dateTime.value = formatTime(hour, minute)
    }, startHour, startMinute, false)

    timePicker.show()
}


fun showDateAndTimePicker(context: Context, dateTime: MutableState<String?>) {

    val currentDateTime = Calendar.getInstance()
    val startYear = currentDateTime.get(Calendar.YEAR)
    val startMonth = currentDateTime.get(Calendar.MONTH)
    val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)

    val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
    val startMinute = currentDateTime.get(Calendar.MINUTE)

    val datePicker = DatePickerDialog(context, { _, year, month, day ->
        TimePickerDialog(context, { _, hour, minute ->
            dateTime.value = formatDateTime(year, month, day, hour, minute)
        }, startHour, startMinute, false).show()
    }, startYear, startMonth, startDay)

    datePicker.show()
}



private fun formatDateTime(year: Int, monthOfYear: Int, dayOfMonth: Int): String{

    val monthStr: String = if ((monthOfYear + 1).toString().length == 1) {
        "0${monthOfYear + 1}"
    } else {
        monthOfYear.toString()
    }

    return "$dayOfMonth - $monthStr - $year"
}

private fun formatDateTime(year: Int, monthOfYear: Int, dayOfMonth: Int, hour: Int, minute: Int): String{

    val monthStr: String = if ((monthOfYear + 1).toString().length == 1) {
        "0${monthOfYear + 1}"
    } else {
        monthOfYear.toString()
    }

    return "$dayOfMonth - $monthStr - $year $hour:$minute"
}

private fun formatTime(hour: Int, minute: Int): String{
    return "$hour:$minute"
}