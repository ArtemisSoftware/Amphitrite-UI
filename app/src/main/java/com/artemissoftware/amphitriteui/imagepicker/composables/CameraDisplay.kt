package com.artemissoftware.amphitriteui.imagepicker.composables

import android.annotation.SuppressLint
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.Executor

@Composable
fun CameraDisplay(
    cameraProviderFuture: ListenableFuture<ProcessCameraProvider>,
    executor: Executor,
    imageCapture: MutableState<ImageCapture?>,
    cameraProvider: ProcessCameraProvider,
    preview: MutableState<Preview?>,
    lifecycleOwner: LifecycleOwner,
) {

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { ctx ->
            val previewView = PreviewView(ctx)
            cameraProviderFuture.addListener({
                val imageAnalysis = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                    .apply {
                        setAnalyzer(executor, FaceAnalyzer())
                    }
                imageCapture.value = ImageCapture.Builder()
                    .setTargetRotation(previewView.display.rotation)
                    .build()

                val cameraSelector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    imageCapture.value,
                    preview.value
                )
            }, executor)
            preview.value = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            previewView
        }
    )
}

private class FaceAnalyzer(): ImageAnalysis.Analyzer {
    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(image: ImageProxy) {
        val imagePic = image.image
        imagePic?.close()
    }
}