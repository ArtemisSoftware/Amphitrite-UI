package com.artemissoftware.amphitriteui.customshapes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
    }



}




@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CustomShapeScreen()
}