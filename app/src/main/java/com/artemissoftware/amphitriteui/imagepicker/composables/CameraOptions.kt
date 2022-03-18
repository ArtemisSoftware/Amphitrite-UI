package com.artemissoftware.amphitriteui.imagepicker.composables

import android.content.Context
import android.net.Uri
import android.widget.Toast
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
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor

@Composable
fun CameraOptions(
    modifier: Modifier,
    context: Context,
    executor: Executor,
    imageCapture: MutableState<ImageCapture?>,
    cameraProvider: ProcessCameraProvider,
    preview: MutableState<Preview?>,
    lifecycleOwner: LifecycleOwner,
    outputDirectory: File,
    onMediaCaptured: (Uri?) -> Unit
) {

    var lensFacing by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }
    var flashEnabled by remember { mutableStateOf(false) }
    var flashRes by remember { mutableStateOf(R.drawable.ic_outline_flashlight_on) }


    var camera: Camera? = null

    var cameraSelector: CameraSelector?


    LaunchedEffect(key1 = true){
        cameraSelector = CameraSelector.Builder()
            .requireLensFacing(lensFacing)
            .build()
        cameraProvider.unbindAll()
        camera = cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector as CameraSelector
        )
    }

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
                camera?.let {
                    if (it.cameraInfo.hasFlashUnit()) {
                        flashEnabled = !flashEnabled
                        flashRes = if (flashEnabled) R.drawable.ic_outline_flashlight_off else R.drawable.ic_outline_flashlight_on
                        it.cameraControl.enableTorch(flashEnabled)
                    }
                }
            }
        ) {
            Icon(
                painter = painterResource(id = flashRes),
                contentDescription = "",
                modifier = Modifier.size(35.dp),
                tint = MaterialTheme.colors.surface
            )
        }

        Button(
            onClick = {
                val imgCapture = imageCapture.value ?: return@Button
                val photoFile = getPhotoFile(outputDirectory)

                val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

                imgCapture.takePicture(
                    outputOptions,
                    executor,
                    object : ImageCapture.OnImageSavedCallback {
                        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                            onMediaCaptured(Uri.fromFile(photoFile))
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            },
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

                 if (lensFacing == CameraSelector.LENS_FACING_BACK) {
                     lensFacing = CameraSelector.LENS_FACING_FRONT
                    flashRes = R.drawable.ic_outline_flashlight_on
                     flashEnabled = false
                }
                else {
                     lensFacing = CameraSelector.LENS_FACING_BACK
                 }


                cameraSelector = CameraSelector.Builder()
                    .requireLensFacing(lensFacing)
                    .build()
                cameraProvider.unbindAll()
                camera = cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector as CameraSelector,
                    imageCapture.value,
                    preview.value
                )
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

private fun getPhotoFile(
    outputDirectory: File,
): File{
    return File(
        outputDirectory,
        SimpleDateFormat("yyyyMMDD-HHmmss", Locale.US)
            .format(System.currentTimeMillis()) + ".jpg"
    )
}




//@Preview(showBackground = true)
//@Composable
//private fun DefaultPreview() {
//
//    CameraOptions(
//        context = LocalContext.current,
//        lifecycleOwner = LocalLifecycleOwner.current,
//        outputDirectory = File("v"),
//        onMediaCaptured = {}
//    )
//}