package com.artemissoftware.amphitriteui.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.ui.theme.Purple500
import com.artemissoftware.amphitriteui.util.Constants.SHIMMER_COLORS


@Composable
fun ShimmerItem(brush: Brush) {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .background(brush)
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "",
                        modifier = Modifier
                            .height(20.dp)
                            .weight(1.0f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    Text(
                        text = "",
                        modifier = Modifier
                            .weight(0.4f)
                            .height(20.dp)
                            .background(brush)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(brush)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {


    val brush = Brush.linearGradient(
        colors = SHIMMER_COLORS,
        start = Offset(10f, 10f),
        //end = Offset(translateAnim.value, translateAnim.value)
    )

    Column {
        ShimmerItem(brush)
    }

}