package com.artemissoftware.amphitriteui.realtimelifecycleupdate.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

//    val black = Color.Black
//    val white = Color.White
//    val green = Color(
//        ContextCompat.getColor(
//            LocalContext.current,
//            R.color.opacity_green
//        )
//    )
//    val red = Color(
//        ContextCompat.getColor(
//            LocalContext.current,
//            R.color.opacity_red
//        )
//    )
//    val fluctuationColour = if (fluctuation == PriceFluctuation.UP) green else red
//
//    val rememberedTitle = remember { title }
//    val animatedElevation = remember { androidx.compose.animation.core.Animatable(4f) }
//    val animatedTextColour = remember { Animatable(black) }
//    val animatedBorderColour = remember { Animatable(white) }
//
//    if (fluctuation != PriceFluctuation.UNKNOWN) {
//        LaunchedEffect(fluctuation) {
//            animatedElevation.animateTo(
//                0f,
//                animationSpec = tween(durationMillis = 500)
//            )
//            animatedElevation.animateTo(
//                4f,
//                animationSpec = tween(durationMillis = 500)
//            )
//        }
//        LaunchedEffect(fluctuation) {
//            animatedTextColour.animateTo(
//                fluctuationColour,
//                animationSpec = tween(durationMillis = 500)
//            )
//        }
//        LaunchedEffect(fluctuation) {
//            animatedBorderColour.animateTo(
//                fluctuationColour,
//                animationSpec = tween(durationMillis = 500)
//            )
//            animatedBorderColour.animateTo(
//                Color.White,
//                animationSpec = tween(durationMillis = 500)
//            )
//        }
//    }


    Card(
//        backgroundColor = Color.White,
//        shape = RoundedCornerShape(percent = 50),
//        border = BorderStroke(1.dp, animatedBorderColour.value),
//        elevation = animatedElevation.value.dp,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .height(56.dp)
    ) {
        Row {
            Text(
                text = "rememberedTitle",
//                modifier = Modifier.padding(16.dp),
//                color = Color.Black,
//                textAlign = TextAlign.Center,
            )
            Text(
                text = price,
//                modifier = Modifier.padding(16.dp)
//                    .weight(1f),
//                color = animatedTextColour.value,
//                textAlign = TextAlign.End,
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