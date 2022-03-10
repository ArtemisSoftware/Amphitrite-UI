package com.artemissoftware.amphitriteui.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.util.Constants

@Composable
fun ShimmerGridItem(brush: Brush) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(brush)
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "",
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(0.8f)
                .background(brush = brush)
        )

        Spacer(modifier = Modifier.padding(3.dp))

        Text(
            text = "",
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(0.8f)
                .background(brush = brush)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {


    val brush = Brush.linearGradient(
        colors = Constants.SHIMMER_COLORS,
        start = Offset(10f, 10f),
        //end = Offset(translateAnim.value, translateAnim.value)
    )

    Column {
        ShimmerGridItem(brush)
    }

}