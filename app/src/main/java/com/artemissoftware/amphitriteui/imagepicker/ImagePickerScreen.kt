package com.artemissoftware.amphitriteui.imagepicker

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ImagePickerScreen() {

    var imageUrl = remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        ImageHolder(imageUrl = imageUrl)

        Spacer(modifier = Modifier.padding(20.dp))

        GalleryImagePickerButton(imageUrl)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ImagePickerScreen()
}