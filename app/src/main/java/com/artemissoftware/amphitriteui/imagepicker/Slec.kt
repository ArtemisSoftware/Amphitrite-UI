package com.artemissoftware.amphitriteui.imagepicker

import androidx.camera.core.ImageCapture
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@ExperimentalPermissionsApi
@Composable
fun Slec(){


    var selectore = remember { mutableStateOf(1) }

    if(selectore.value == 0){
        ImagePickerScreen()
    }
    else{
        CameraScreen()
    }

}