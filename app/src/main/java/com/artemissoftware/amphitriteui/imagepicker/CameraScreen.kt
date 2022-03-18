package com.artemissoftware.amphitriteui.imagepicker

import android.content.Context
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.imagepicker.composables.CameraDisplay
import com.artemissoftware.amphitriteui.imagepicker.composables.CameraOptions
import java.io.File


@Composable
fun CameraScreen(){

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    val executor = ContextCompat.getMainExecutor(context)

    var imageCapture = remember { mutableStateOf<ImageCapture?>(null) }


    val cameraProvider = cameraProviderFuture.get()


    var preview = remember { mutableStateOf<Preview?>(null) }


    Box {

        CameraDisplay(
            cameraProviderFuture = cameraProviderFuture,
            executor = executor,
            imageCapture = imageCapture,
            cameraProvider = cameraProvider,
            preview = preview,
            lifecycleOwner = lifecycleOwner
        )


        CameraOptions(
            modifier = Modifier.align(Alignment.BottomCenter),
            context = context,
            executor = executor,
            imageCapture = imageCapture,
            cameraProvider = cameraProvider,
            preview = preview,
            lifecycleOwner = lifecycleOwner,
            outputDirectory = getDirectory(context),
            onMediaCaptured = { url -> }
        )
    }
}


//Store the capture image
private fun getDirectory(context: Context): File {

    with(context){
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CameraScreen()
}