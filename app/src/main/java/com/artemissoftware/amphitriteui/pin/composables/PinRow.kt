package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PinRow(
    start: Int,
    end: Int,
    onClick: (Int) -> Unit,
){

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        (start..end).forEach {
            PinKeyItem(
//                onClick = { inputPin.add(it) }
            ) {
                Text(
                    text = it.toString(),
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }

}


@Composable
fun PinOptionRow(

){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Success",
            modifier = Modifier
                .size(25.dp)
                .clickable { }
        )
        PinKeyItem(
//            onClick = { inputPin.add(0) },
//            modifier = Modifier.padding(horizontal = 16.dp,
//                vertical = 8.dp)
        ) {
            Text(
                text = "0",
                style = typography.h5,
                modifier = Modifier.padding(4.dp)
            )
        }
        Icon(
            imageVector = Icons.Outlined.Backspace,
            contentDescription = "Clear",
            modifier = Modifier
                .size(25.dp)
                .clickable {
//                    if (inputPin.isNotEmpty()) {
//                        inputPin.removeLast()
//                    }
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PinRowPreview() {
    PinRow(
        start = 1,
        end = 3,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PinOptionRowPreview() {
    PinOptionRow(

    )
}