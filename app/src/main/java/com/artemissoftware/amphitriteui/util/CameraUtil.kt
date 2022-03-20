package com.artemissoftware.amphitriteui.util

import android.content.Context
import com.artemissoftware.amphitriteui.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object CameraUtil {

    fun getPhotoFile(
        outputDirectory: File,
    ): File {
        return File(
            outputDirectory,
            SimpleDateFormat("yyyyMMDD-HHmmss", Locale.US)
                .format(System.currentTimeMillis()) + ".jpg"
        )
    }


    fun getDirectory(context: Context): File {

        with(context){
            val mediaDir = externalMediaDirs.firstOrNull()?.let {
                File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
            }
            return if (mediaDir != null && mediaDir.exists())
                mediaDir else filesDir
        }
    }

}