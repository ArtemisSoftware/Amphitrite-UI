package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun PinRow(
    start: Int,
    end: Int,
    onPinClick: (Int) -> Unit,
){

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        (start..end).forEach {
            PinKeyItem(
                onPinClick = {
                    onPinClick.invoke(it)
                }
            ) {
                Text(
                    text = it.toString(),
                    style = typography.h5
                )
            }
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun PinOptionRow(
    inputPin: SnapshotStateList<Int>,
    onPinClick: (Int) -> Unit,
) {
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
            onPinClick = {
                onPinClick.invoke(0)
            },
            modifier = Modifier.padding(horizontal = 16.dp,
                vertical = 8.dp)
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
                    if (inputPin.isNotEmpty()) {
                        inputPin.removeLast()
                    }
                }
        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun PinRowPreview() {
    PinRow(
        start = 1,
        end = 3,
        onPinClick = {}
    )
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun PinOptionRowPreview() {
    val inputPin = remember { mutableStateListOf<Int>() }
    PinOptionRow(inputPin, onPinClick = {})
}