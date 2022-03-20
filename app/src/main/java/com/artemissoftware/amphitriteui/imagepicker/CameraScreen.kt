package com.artemissoftware.amphitriteui.imagepicker

import android.net.Uri
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.imagepicker.composables.CameraDisplay
import com.artemissoftware.amphitriteui.imagepicker.composables.CameraOptions
import com.artemissoftware.amphitriteui.util.CameraUtil
import java.io.File


@Composable
fun CameraScreen(
    imageUrl: MutableState<Uri?>,
    functionSelector: MutableState<Int>
){

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    val executor = ContextCompat.getMainExecutor(context)

    var imageCapture = remember { mutableStateOf<ImageCapture?>(null) }


    val cameraProvider = cameraProviderFuture.get()


    var preview = remember { mutableStateOf<Preview?>(null) }



    var camera by remember { mutableStateOf<Camera?>(null) }
    var cameraSelector by remember { mutableStateOf<CameraSelector?>(null) }

    //Flash
    var flashEnabled by remember { mutableStateOf(false) }
    var flashIcon by remember { mutableStateOf(R.drawable.ic_outline_flashlight_on) }
    var lensFacing by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }





    val onMediaCaptured = { uri: Uri? ->

        functionSelector.value = 0
        imageUrl.value = uri

    }

    val onFlashClick = {
        camera?.let {
            if (it.cameraInfo.hasFlashUnit()) {
                flashEnabled = !flashEnabled
                flashIcon = if (flashEnabled) R.drawable.ic_outline_flashlight_off else R.drawable.ic_outline_flashlight_on
                it.cameraControl.enableTorch(flashEnabled)
            }
        }
    }


    val onPictureCapture = { outputDirectory: File ->

        imageCapture.value?.let { imgCapture->

            val photoFile = CameraUtil.getPhotoFile(outputDirectory)
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
        }
    }




    val onCameraRotate = {

        if (lensFacing == CameraSelector.LENS_FACING_BACK) {
            lensFacing = CameraSelector.LENS_FACING_FRONT
            flashIcon = R.drawable.ic_outline_flashlight_on
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




    LaunchedEffect(key1 = true){
        cameraSelector = CameraSelector.Builder()
            .requireLensFacing(lensFacing)
            .build()
        //--cameraProvider.unbindAll()
        camera = cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector as CameraSelector
        )
    }


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
            onFlashClick = { onFlashClick() },
            onPictureCapture  = { onPictureCapture(CameraUtil.getDirectory(context = context)) },
            onCameraRotate = { onCameraRotate() },
            flashIcon = flashIcon,
        )
    }
}



@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    //CameraScreen()
}