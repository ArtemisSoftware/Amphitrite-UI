package com.artemissoftware.amphitriteui.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.pin.composables.PinDisplay
import com.artemissoftware.amphitriteui.pin.composables.PinKeyboard
import com.artemissoftware.amphitriteui.pin.util.PinConstants.PIN_PASSWORD
import com.artemissoftware.amphitriteui.pin.util.PinConstants.PIN_SIZE
import kotlinx.coroutines.delay

@ExperimentalMaterialApi
@Composable
fun PinScreen() {

    val inputPin = remember { mutableStateListOf<Int>() }
    val error = remember { mutableStateOf<String>("") }
    val showSuccess = remember { mutableStateOf(false) }

    if (inputPin.size == 4) {
        LaunchedEffect(true) {
            delay(300)

            if (inputPin.joinToString("") == PIN_PASSWORD) {
                showSuccess.value = true
                error.value = ""
            } else {
                inputPin.clear()
                error.value = "Wrong pin, Please retry!"
            }
        }
    }


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

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PinScreen()
}