package com.artemissoftware.amphitriteui.imagepicker

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@ExperimentalPermissionsApi
@Composable
fun CameraApp(){


    var functionSelector = remember { mutableStateOf(0) }
    var imageUrl = remember { mutableStateOf<Uri?>(null) }


    if(functionSelector.value == 0){
        ImagePickerScreen(functionSelector = functionSelector, imageUrl = imageUrl)
    }
    else{
        CameraScreen(
            functionSelector = functionSelector, imageUrl = imageUrl
        )
    }

}