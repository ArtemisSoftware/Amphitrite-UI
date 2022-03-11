package com.artemissoftware.amphitriteui.expandablelist.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.expandablelist.ItemExp
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@Composable
fun ExpandableCard(card: ItemExp){

    Card {

        Column(
//            modifier = Modifier
//                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.weight(0.85f)
                    ) {
                        Text(
                            text = card.title,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        )
                    }

//                    Column(
//                        modifier = Modifier.weight(0.15f)
//                    ) {
//                        CardArrow(
//                            degrees = arrowRotationDegree,
//                            onClick = onCardArrowClick
//                        )
//                    }
                }
            }
//            ExpandableContent(expanded)
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

    val card = ItemExp(1, "Title")
    ExpandableCard(card = card)
}