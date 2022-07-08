package com.artemissoftware.amphitriteui.animation.vynilplayer.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.R

@Composable
fun Vinyl(
    modifier: Modifier = Modifier,
    rotationDegrees: Float = 0f
) {
    Box(
        modifier = modifier
//            .clip(VinylShape())
    ) {

        // Vinyl background
        Image(
            modifier = Modifier
                .rotate(rotationDegrees),
            painter = painterResource(id = R.drawable.vinyl_background),
            contentDescription = ""
        )

        // Vinyl lights effect
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.vinyl_light),
            contentDescription = "",
        )

        // Vinyl 'album' cover
        // For using with Coil or Glide, wrap into surface with shape
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .rotate(rotationDegrees)
                .clip(CircleShape),
            painter = painterResource(R.drawable.album_cover),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    Vinyl()
}