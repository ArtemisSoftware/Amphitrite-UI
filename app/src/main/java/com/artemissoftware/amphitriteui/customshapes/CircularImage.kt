package com.artemissoftware.amphitriteui.customshapes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R

@Composable
fun CircularImage() {

    Image(
        painter = painterResource(id = R.drawable.artemis_4),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape
            )
            .graphicsLayer { // call this function to apply custom shadow elevation, otherwise use `clip()`
                shadowElevation = 36.dp.toPx() //your custom shadow elevation in px
                clip = true //make sure to set clip to true
                shape = CircleShape
            },
    )
}

@Composable
fun CircularImage_v2() {

    Image(
        painter = painterResource(id = R.drawable.artemis_4),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape,
                clip = true
            )
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape
            )
    )
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Column {
        CircularImage()
        CircularImage_v2()
    }


}