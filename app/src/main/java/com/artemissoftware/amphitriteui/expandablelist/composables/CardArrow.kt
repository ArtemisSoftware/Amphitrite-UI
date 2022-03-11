package com.artemissoftware.amphitriteui.expandablelist.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.expandablelist.ItemExp

@Composable
fun CardArrow(
    degrees: Float,
    color: Color = Color.Black,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_exp_arrow),
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
                tint = color
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    CardArrow(degrees = 34F, onClick = {})
}