package com.artemissoftware.amphitriteui.expandablelist.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.expandablelist.ItemExp

@Composable
fun FixedContent(
    card: ItemExp,
    degrees: Float,
    color: Color = Color.Black,
    onClick: () -> Unit
){

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.weight(0.85f)
        ) {
            Text(
                text = card.title,
                color = color,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }

        Column(
            modifier = Modifier.weight(0.15f)
        ) {
            CardArrow(
                degrees = degrees,
                onClick = onClick,
                color = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    val card = ItemExp(1, "Title")

    Column {
        FixedContent(card = card, onClick = {}, degrees = 160F)
    }
}