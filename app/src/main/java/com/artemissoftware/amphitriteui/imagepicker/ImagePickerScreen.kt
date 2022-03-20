package com.artemissoftware.amphitriteui.imagepicker

import android.Manifest
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalPermissionsApi
@Composable
fun ImagePickerScreen(selectore: MutableState<Int>) {

    var imageUrl = remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        ImageHolder(imageUrl = imageUrl)

        Spacer(modifier = Modifier.padding(20.dp))

        GalleryImagePickerButton(imageUrl)
        Spacer(modifier = Modifier.padding(4.dp))
        PermissionButton(permission = Manifest.permission.CAMERA)

        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedButton(onClick = { selectore.value = 1 },
            modifier= Modifier.size(80.dp),  //avoid the oval shape
            shape = CircleShape,
            border= BorderStroke(1.dp, Color.Blue),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
        ) {
            Icon(Icons.Default.Face, contentDescription = "content description")
        }

    }
}

@ExperimentalPermissionsApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    //ImagePickerScreen()
}