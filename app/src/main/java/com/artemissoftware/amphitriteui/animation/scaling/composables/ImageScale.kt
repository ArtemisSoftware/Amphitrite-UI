package com.artemissoftware.amphitriteui.animation.scaling.composables

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ImageScale(modifier: Modifier) {
    Image(
        imageVector = Icons.Default.BrokenImage,
        contentDescription = "Icons",
        modifier = modifier

    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ImageScale(Modifier)
}