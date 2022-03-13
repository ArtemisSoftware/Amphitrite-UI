package com.artemissoftware.amphitriteui.imagepicker

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*

@Composable
fun ImagePickerScreen() {

    var imageUrl = remember { mutableStateOf<Uri?>(null) }

    Column {

        GalleryImagePickerButton(imageUrl)
    }
}