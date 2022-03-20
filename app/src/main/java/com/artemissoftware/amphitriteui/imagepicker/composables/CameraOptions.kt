package com.artemissoftware.amphitriteui.imagepicker.composables

import android.content.Context
import android.net.Uri
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import java.io.File
import java.util.*
import java.util.concurrent.Executor
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CameraOptions(
    modifier: Modifier,
    onFlashClick: () -> Unit,
    onPictureCapture: () -> Unit,
    onCameraRotate: () -> Unit,
    flashIcon: Int = R.drawable.ic_outline_flashlight_on,
//    context: Context,
//    executor: Executor,
//    imageCapture: MutableState<ImageCapture?>,
//    cameraProvider: ProcessCameraProvider,
//    preview: MutableState<Preview?>,
//    lifecycleOwner: LifecycleOwner,
//    outputDirectory: File,
//    onMediaCaptured: (Uri?) -> Unit
) {



    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Purple500)
            .padding(8.dp)
    ) {

        IconButton(
            onClick = {
                onFlashClick()
            }
        ) {
            Icon(
                painter = painterResource(id = flashIcon),
                contentDescription = "",
                modifier = Modifier.size(35.dp),
                tint = MaterialTheme.colors.surface
            )
        }

        Button(
            onClick = { onPictureCapture.invoke() },
            modifier = Modifier
                .size(70.dp)
                .background(Purple500, CircleShape)
                .shadow(4.dp, CircleShape)
                .clip(CircleShape)
                .border(5.dp, Color.LightGray, CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple500),
        ) {

        }

        IconButton(
            onClick = {
                onCameraRotate()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_rotate),
                contentDescription = "",
                modifier = Modifier.size(35.dp),
                tint = MaterialTheme.colors.surface
            )
        }
    }
}






@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CameraOptions(
        modifier = Modifier,
        onFlashClick = {},
        onPictureCapture = {},
        onCameraRotate = {},
    )
}