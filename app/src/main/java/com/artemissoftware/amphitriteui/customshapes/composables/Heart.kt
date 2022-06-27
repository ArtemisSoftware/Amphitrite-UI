package com.artemissoftware.amphitriteui.customshapes.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.customshapes.CircularImage
import com.artemissoftware.amphitriteui.customshapes.CircularImage_v2
import com.artemissoftware.amphitriteui.customshapes.extensions.heartPath

@Composable
fun Heart(): GenericShape {
    return GenericShape { size, _ ->
        heartPath(size = size)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Image(
        painter = painterResource(id = R.drawable.artemis_4),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .clip(Heart()),
    )
}