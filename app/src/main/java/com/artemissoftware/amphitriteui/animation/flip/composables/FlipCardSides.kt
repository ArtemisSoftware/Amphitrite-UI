package com.artemissoftware.amphitriteui.animation.flip.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.ForwardColor
import com.artemissoftware.amphitriteui.ui.theme.PreviousColor


@Composable
fun FlipCardSides (
    rotation: State<Float>,
    front: @Composable () -> Unit = {},
    back: @Composable () -> Unit = {}
){


    if (rotation.value <= 90f) {
        Box {
            front()
        }
    } else {
        Box {
            back()

        }
    }
}

@Composable
fun FrontSide (){

    Box(
        modifier = Modifier
            .background(ForwardColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.artemis_6),
            contentDescription = "Forward",
            modifier = Modifier.size(220.dp)
        )
    }
}

@Composable
fun BackSide (){

    Box(
        modifier = Modifier
            .background(PreviousColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.artemis_4),
            contentDescription = "Forward",
            modifier = Modifier.size(220.dp),
            contentScale = ContentScale.Crop
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun FrontSidePreview() {
    FrontSide()
}

@Preview(showBackground = true)
@Composable
private fun BackSidePreview() {
    BackSide()
}
