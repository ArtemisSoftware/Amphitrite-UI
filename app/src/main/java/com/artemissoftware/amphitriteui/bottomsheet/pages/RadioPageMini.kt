package com.artemissoftware.amphitriteui.bottomsheet.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.RadioPageMini() {
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




@Preview(showBackground = true)
@Composable
private fun RadioScreenSmallPreview() {
    Row {
        RadioPageMini()
    }
}