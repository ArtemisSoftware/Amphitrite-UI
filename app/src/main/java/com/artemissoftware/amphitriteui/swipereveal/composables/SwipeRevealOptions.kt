package com.artemissoftware.amphitriteui.swipereveal.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.ui.theme.Purple200

@Composable
fun SwipeRevealOptions(bgColor: MutableState<Color>) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        IconButton(
            onClick = {
                bgColor.value = Color.Green
            },
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        ) {
            Icon(
                Icons.Filled.Edit,
                contentDescription = "Edit",
                tint = Color.Green
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        IconButton(
            onClick = {
                bgColor.value = Color.Red
            },
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        ) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Delete",
                tint = Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    var bgColor = remember { mutableStateOf(Purple200) }
    SwipeRevealOptions(bgColor)
}