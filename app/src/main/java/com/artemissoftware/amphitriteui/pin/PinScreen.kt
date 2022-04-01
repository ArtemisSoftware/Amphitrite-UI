package com.artemissoftware.amphitriteui.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.pin.composables.PinDisplay
import com.artemissoftware.amphitriteui.pin.composables.PinKeyboard
import com.artemissoftware.amphitriteui.pin.util.PinConstants.PIN_SIZE

@Composable
fun PinScreen() {

    val inputPin = remember { mutableStateListOf<Int>() }
    val error = remember { mutableStateOf<String>("") }
    val showSuccess = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


            Box(
                modifier = Modifier.fillMaxSize()
            ) {


                PinDisplay(
                    inputPin = inputPin,
                    pinSize = PIN_SIZE,
                    showSuccess = showSuccess,
                    error= error
                )

                PinKeyboard(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    inputPin = inputPin
                )

            }


    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PinScreen()
}