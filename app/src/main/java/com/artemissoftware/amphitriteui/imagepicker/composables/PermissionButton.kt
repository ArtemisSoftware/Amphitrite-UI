package com.artemissoftware.amphitriteui.imagepicker

import android.Manifest
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@ExperimentalPermissionsApi
@Composable
fun PermissionButton(permission: String) {

    val (title, manifestPermission, valid) = when(permission){

        Manifest.permission.CAMERA->{
            Triple("CAMERA permission", Manifest.permission.CAMERA, true)
        }
        else->{
            Triple("No permission defined", "", false)

        }
    }

    val cameraPermissionState = rememberPermissionState(permission = manifestPermission)

    Button(
        onClick = {
            if (valid)
                cameraPermissionState.launchPermissionRequest()
        }
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}