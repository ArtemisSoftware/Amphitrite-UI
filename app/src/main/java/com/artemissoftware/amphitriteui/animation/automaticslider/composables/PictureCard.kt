package com.artemissoftware.amphitriteui.animation.automaticslider.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PictureCard() {

    Card(
//        modifier = Modifier
//            .graphicsLayer {
//                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//                lerp(
//                    start = 0.85f,
//                    stop = 1f,
//                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                ).also { scale ->
//                    scaleX = scale
//                    scaleY = scale
//                }
//            }
//            .fillMaxWidth()
//            .padding(15.dp, 0.dp, 15.dp, 0.dp),
//        shape = RoundedCornerShape(20.dp)
    ) {
//        val natural = natural[page]
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
//                .align(Alignment.Center)
        ) {
//            Image(
//                painter = painterResource(
//                    id = when (page) {
//                        1 -> R.drawable.artemis_4
//                        2 -> R.drawable.artemis_6
//                        3 -> R.drawable.image_3
//                        4 -> R.drawable.image_4
//                        5 -> R.drawable.image_5
//                        else -> R.drawable.artemis_6
//                    }
//                ),
//                contentDescription = "Image",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(15.dp)
            ) {
                Text(
                    text = "natural.title",
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

//                val ratingBar = RatingBar(
//                    LocalContext.current, null, R.attr.ratingBarStyleSmall
//                ).apply {
//                    rating = natural.rating
//                    progressDrawable.setColorFilter(
//                        android.graphics.Color.parseColor("#FF0000"),
//                        PorterDuff.Mode.SRC_ATOP
//                    )
//                }
//                AndroidView(
//                    factory = { ratingBar },
//                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
//                )

                Text(
                    text = "natural.desc",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PictureCard()
}