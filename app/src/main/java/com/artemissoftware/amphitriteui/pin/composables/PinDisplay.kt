package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R

@Composable
fun PinDisplay(
    pinSize: Int,
    showSuccess: MutableState<Boolean>,
    error: MutableState<String>,
    inputPin: SnapshotStateList<Int>
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.artemis_4),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Enter pin to unlock",
            style = typography.h6,
            modifier = Modifier.padding(16.dp),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (showSuccess.value) {
            LottieLoadingView(
                //context = context,
                file = "success.json",
                iterations = 1,
                modifier = Modifier.size(100.dp)
            )
        } else {
            PinOTP(pinSize = pinSize, inputPin = inputPin)
        }
        Text(
            text = error.value,
            color = MaterialTheme.colors.error,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))
    }
}


@Preview(showBackground = true)
@Composable
private fun PinOptionRowPreview() {

    val error = remember { mutableStateOf<String>("") }
    val showSuccess = remember { mutableStateOf(false) }

    val inputPin = remember { mutableStateListOf<Int>() }

    PinDisplay(
        pinSize = 4,
        showSuccess = showSuccess,
        error = error,
        inputPin = inputPin
    )
}