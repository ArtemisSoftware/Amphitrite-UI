package com.artemissoftware.amphitriteui.animation.automaticslider.composables

import android.graphics.PorterDuff
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.animation.automaticslider.models.GodPicture

@Composable
fun PictureCard(godPicture: GodPicture) {

    Card(
        modifier = Modifier
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
            .fillMaxWidth()
            .padding(15.dp, 0.dp, 15.dp, 0.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                //.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = godPicture.img),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(15.dp)
            ) {
                Text(
                    text = godPicture.title,
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                val ratingBar = RatingBar(
                    LocalContext.current,
                    null,
                    R.attr.ratingBarStyleSmall
                ).apply {
                    rating = godPicture.rating
                    progressDrawable.setColorFilter(
                        android.graphics.Color.parseColor("#FF0000"),
                        PorterDuff.Mode.SRC_ATOP
                    )
                }
                AndroidView(
                    factory = { ratingBar },
                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                )

                Text(
                    text = godPicture.desc,
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
    PictureCard(GodPicture.mockList[0])
}