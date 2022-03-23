package com.artemissoftware.amphitriteui.bottomsheet.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Radio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.Purple500

@Composable
fun RowScope.RadioScreenSmall() {
    RadioLogoSmall(
        modifier = Modifier.padding(10.dp)
    )

    Text(
        text = "FM Title / Make it Easy",
        color = Color.White,
        style = MaterialTheme.typography.caption,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = Modifier
            .weight(1f)
            .padding(15.dp)
    )
    IconButton(
        onClick = {

        },
        modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 15.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "",
            tint = Color.White
        )
    }
}



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

@Preview(showBackground = true)
@Composable
private fun RadioLogoSmallPreview() {
    RadioLogoSmall(Modifier, Modifier)
}

@Preview(showBackground = true)
@Composable
private fun RadioScreenSmallPreview() {
    Row {
        RadioScreenSmall()
    }
}