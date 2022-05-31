package com.artemissoftware.amphitriteui.barcode

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import com.artemissoftware.amphitriteui.util.BarcodeUtil.generateBarCode

@Preview(showBackground = false)
@Composable
fun GenerateBarCodeScreen() {

    val barCodeGenerate = remember { mutableStateOf("") }
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 15.dp, 15.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        bitmap.value?.asImageBitmap()?.let { it ->
            Image(
                bitmap = it,
                contentDescription = "Generate BarCode Image",
                modifier = Modifier.size(250.dp)
            )
        }
        OutlinedTextField(
            value = barCodeGenerate.value,
            onValueChange = { barCodeGenerate.value = it },
            label = { Text(text = "Enter BarCode") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                bitmap.value = generateBarCode(barCodeGenerate.value)
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(60.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Purple500)
        ) {
            Text(
                text = "Submit",
                color = Color.White,
                fontSize = 13.sp
            )
        }
    }

}