package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PinKeyboard(
    modifier: Modifier,
    inputPin: SnapshotStateList<Int>
) {

    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = 20.dp)
    ) {

        PinRow(
            start = 1,
            end = 3,
            onClick = {index->
                inputPin.add(index)
            }
        )

        PinRow(
            start = 4,
            end = 6,
            onClick = {index->
//                            inputPin.add(it)
            }
        )

        PinRow(
            start = 7,
            end = 9,
            onClick = {index->
//                            inputPin.add(it)
            }
        )

        PinOptionRow(
            inputPin = inputPin
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    val inputPin = remember { mutableStateListOf<Int>() }
    PinKeyboard(Modifier, inputPin)
}