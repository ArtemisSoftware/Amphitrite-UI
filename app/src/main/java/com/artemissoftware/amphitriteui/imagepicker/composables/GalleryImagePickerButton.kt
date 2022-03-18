package com.artemissoftware.amphitriteui.imagepicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.player.ExoPlayer
import com.artemissoftware.amphitriteui.util.Constants

@Composable
fun GalleryImagePickerButton(imageUrl: MutableState<Uri?>) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUrl.value = uri
    }

    Button(
        onClick = {
            launcher.launch("image/*")
        }
    ) {
        Text(
            text = "Open gallery",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
