package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PinOTP(
    pinSize: Int
//    inputPin
) {

    Row {
        (0 until pinSize).forEach {
            Icon(
                imageVector = if (/*inputPin.size*/6 > it) Icons.Default.Circle else Icons.Outlined.Circle,
                contentDescription = it.toString(),
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp),
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PinOptionRowPreview() {
    PinOTP(
        pinSize = 6,
    )
}