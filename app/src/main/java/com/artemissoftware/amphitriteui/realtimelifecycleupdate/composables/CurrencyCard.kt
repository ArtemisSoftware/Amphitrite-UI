package com.artemissoftware.amphitriteui.realtimelifecycleupdate.composables

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.PriceFluctuation

@Composable
fun CurrencyCard(
    title: String,
    price: String,
    fluctuation: PriceFluctuation
) {


    val fluctuationColour = if (fluctuation == PriceFluctuation.UP) Color.Green else Color.Red//green else red

    val rememberedTitle = title//remember { title }
    val animatedElevation = remember { Animatable(4f) }
    val animatedTextColour = remember { Animatable(Color.Black) }
    val animatedBorderColour = remember { Animatable(Color.White) }
//
    if (fluctuation != PriceFluctuation.UNKNOWN) {
        LaunchedEffect(fluctuation) {
            animatedElevation.animateTo(
                0f,
                animationSpec = tween(durationMillis = 500)
            )
            animatedElevation.animateTo(
                4f,
                animationSpec = tween(durationMillis = 500)
            )
        }
        LaunchedEffect(fluctuation) {
            animatedTextColour.animateTo(
                fluctuationColour,
                animationSpec = tween(durationMillis = 500)
            )
        }
        LaunchedEffect(fluctuation) {
            animatedBorderColour.animateTo(
                fluctuationColour,
                animationSpec = tween(durationMillis = 500)
            )
            animatedBorderColour.animateTo(
                Color.White,
                animationSpec = tween(durationMillis = 500)
            )
        }
    }


    Card(
//        backgroundColor = Color.White,
        shape = RoundedCornerShape(percent = 15),
        border = BorderStroke(1.dp, animatedBorderColour.value),
        elevation = animatedElevation.value.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = rememberedTitle,
                modifier = Modifier.padding(0.dp),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = price,
                modifier = Modifier.padding(0.dp)
                    .weight(1f),
                color = animatedTextColour.value,
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    CurrencyCard(
        title = "title",
        price = "2000",
        fluctuation = PriceFluctuation.DOWN
    )
}