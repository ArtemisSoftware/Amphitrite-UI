package com.artemissoftware.amphitriteui.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.pin.composables.PinKeyItem
import com.artemissoftware.amphitriteui.pin.composables.PinOptionRow
import com.artemissoftware.amphitriteui.pin.composables.PinRow
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@Composable
fun PinScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column() {

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp)
                ) {

                    PinRow(
                        start = 1,
                        end = 3,
                        onClick = {index->
//                            inputPin.add(it)
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

                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PinScreen()
}