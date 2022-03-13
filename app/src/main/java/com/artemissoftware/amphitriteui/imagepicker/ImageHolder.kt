package com.artemissoftware.amphitriteui.imagepicker

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R

@Composable
fun ImageHolder(imageUrl: MutableState<Uri?>){

    imageUrl?.let { uri->

        uri.value?.let {



        } ?: run{

            Image(
                painter = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = "Gallery Image",
                modifier = Modifier.size(400.dp)
            )
        }





//            if (Build.VERSION.SDK_INT < 28) {
//                bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
//            } else {
//                val source = ImageDecoder.createSource(context.contentResolver, it)
//                bitmap.value = ImageDecoder.decodeBitmap(source)
//            }
//
//            bitmap.value?.let { bitmap ->
//                Image(
//                    bitmap = bitmap.asImageBitmap(),
//                    contentDescription = "Gallery Image",
//                    modifier = Modifier.size(400.dp)
//                )
//            }
    }
}

@Preview(showBackground = true, backgroundColor = 1L)
@Composable
private fun DefaultPreview() {

    var imageUrl = remember { mutableStateOf<Uri?>(null) }
    ImageHolder(imageUrl)
}