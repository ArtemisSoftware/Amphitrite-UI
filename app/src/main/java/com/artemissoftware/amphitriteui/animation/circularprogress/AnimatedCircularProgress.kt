package com.artemissoftware.amphitriteui.animation.circularprogress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.animation.circularprogress.composables.CircularProgress

@Composable
fun AnimatedCircularProgress(modifier: Modifier) {

    var isPlaying = remember{ mutableStateOf(false) }

    var animation = animateFloatAsState(
        targetValue = if(isPlaying.value) 180f else 0f,
        animationSpec = tween(
            durationMillis = 3000,
            delayMillis = 300
        )
    )
    
    LaunchedEffect(true){
        isPlaying.value = true
    }

    Box(
        modifier = Modifier
            .size(300.dp),
        contentAlignment = Alignment.Center
    ) {

        CircularProgress(modifier = modifier, sweepAngle = animation.value)

        Text(
            text = animation.value.toString(),
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AnimatedCircularProgress(modifier = Modifier
        .size(250.dp)
        .padding(8.dp))
}