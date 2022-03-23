package com.artemissoftware.amphitriteui.bottomsheet.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.bottomsheet.BottomSheetScreen

@Composable
fun PlayerControls(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier
                .padding(start = 15.dp, end = 8.dp)
        ) {
            Image(
                imageVector = Icons.Filled.VolumeUp,
                contentDescription = "Volume"
            )
        }


        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.SkipPrevious,
                    contentDescription = "Previous"
                )
            }

            PlayPauseButton(onClick = {})

            IconButton(
                onClick = {  },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.SkipNext,
                    contentDescription = "Next"
                )
            }
        }


        IconButton(
            onClick = {  },
            modifier = Modifier
                .padding(start = 8.dp, end = 15.dp)
        ) {
            Image(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favourite"
            )
        }
    }
}


@Composable
fun PlayPauseButton(
    onClick: () -> Unit
) {
    CircleIconButtonLarge(
        background = Color.LightGray,
        imageVector = Icons.Filled.PlayArrow,
        onClick = onClick
    )
}

@Composable
fun CircleIconButtonLarge(
    background: Color,
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape)
            .background(background, CircleShape)
            .clickable(
//                indication = rememberRipple(bounded = true),
//                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick() }
            )
    ) {
        Icon(imageVector = imageVector, contentDescription = "")
    }
}



@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PlayerControls(Modifier)
}