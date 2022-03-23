package com.artemissoftware.amphitriteui.bottomsheet.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Radio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.Purple500


@Composable
fun RadioLogoSmall(
    modifier: Modifier = Modifier,
    placeholder: Modifier = modifier
) {
    val painter = rememberImagePainter(
        data = R.drawable.ic_baseline_radio_24,
        builder = {
            crossfade(true)
            transformations(CircleCropTransformation())
        },
        onExecute = { _, _-> true }
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .shadow(1.dp, CircleShape)
            .background(
                color = Purple500,
                shape = CircleShape
            )
            .then(placeholder)
    ) {
        Image(
            painter = painter,
            contentDescription = "Radio",
            modifier = Modifier
                .size(48.dp)
        )

        when (painter.state) {
            is ImagePainter.State.Error -> {
                Icon(
                    imageVector = Icons.Filled.Radio,
                    contentDescription = "Radio",
                    tint = Purple500,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun RadioLogo() {
    val painter = rememberImagePainter(
        data = R.drawable.ic_baseline_radio_24,
        builder = {
            crossfade(true)
        },
        onExecute = { _, _-> true }
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(250.dp)
            .shadow(30.dp, CircleShape)
            .background(
                color = Color.LightGray,
                shape = CircleShape
            )
            .border(10.dp, Purple500, CircleShape)
    ) {
        Image(
            painter = painter,
            contentDescription = "Radio",
            modifier = Modifier
                .size(150.dp)
                .padding(15.dp)
        )

        when (painter.state) {
            is ImagePainter.State.Error -> {
                Icon(
                    imageVector = Icons.Filled.Radio,
                    contentDescription = "Radio",
                    tint = Purple500,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RadioLogoSmallPreview() {
    RadioLogoSmall(Modifier, Modifier)
}

@Preview(showBackground = true)
@Composable
private fun RadioLogoPreview() {
    RadioLogo()
}