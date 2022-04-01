package com.artemissoftware.amphitriteui.pin.composables

import android.content.Context
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.artemissoftware.amphitriteui.pin.PinScreen

@Composable
fun LottieLoadingView(
    //context: Context,
    file: String,
    modifier: Modifier = Modifier,
    iterations: Int = 10
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Asset(file))
    LottieAnimation(
        composition = composition,
        modifier = modifier.defaultMinSize(300.dp),
        iterations = iterations
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    LottieLoadingView(
        //context = context,
        file = "success.json",
        iterations = 1,
        modifier = Modifier.size(100.dp)
    )
}