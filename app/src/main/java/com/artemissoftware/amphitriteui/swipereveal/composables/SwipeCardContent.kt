package com.artemissoftware.amphitriteui.swipereveal.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@Composable
fun SwipeCardContent() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        //verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.artemis_4),
                contentDescription = "Circle Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Column {
                Text(
                    text = "Swipe Layout",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and type setting industry...",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SwipeCardContent()
}