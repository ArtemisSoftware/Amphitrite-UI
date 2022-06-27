package com.artemissoftware.amphitriteui.customshapes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.customshapes.composables.Heart

@Composable
fun CustomShapeScreen() {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        item {
            CircularImage()
        }

        item {
            CircularImage_v2()
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.artemis_4),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(Heart()),
            )
        }
    }



}




@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CustomShapeScreen()
}