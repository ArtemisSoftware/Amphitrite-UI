package com.artemissoftware.amphitriteui.realtimeupdate.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.realtimeupdate.model.RealTimeUpdate
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@Composable
fun RealTimeUpdateItemCard(
    realTimeUpdateItem: RealTimeUpdate,
    onDownloadClick: () -> Unit
) {

        val title = realTimeUpdateItem.title
//    val title = remember { realTimeUpdateItem.title }
//    val isDownloaded = realTimeUpdateItem.downloadProgress == 100
//    val animatedProgress: Float by animateFloatAsState(targetValue = realTimeUpdateItem.downloadProgress / 100f)
//    val black = Color.Black
//    val white = Color.White
//    val green = Color(
//        ContextCompat.getColor(
//            LocalContext.current,
//            R.color.opacity_green
//        )
//    )


    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            Text(
                text = title,
                modifier = Modifier.padding(16.dp),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

//            Box(
//                modifier = Modifier
//                    .height(56.dp)
//                    .padding(horizontal = 16.dp)
//                    .weight(1f)
//            ) {
//                CircularProgressIndicator(
//                    strokeWidth = 2.dp,
//                    modifier = Modifier
//                        .size(36.dp)
//                        .align(Alignment.CenterEnd),
//                    progress = animatedProgress,
//                    color = if (isDownloaded) green else black
//                )
//                if (isDownloaded) {
//                    Icon(
//                        modifier = Modifier
//                            .size(36.dp)
//                            .padding(8.dp)
//                            .align(Alignment.CenterEnd),
//                        painter = painterResource(id = R.drawable.ic_baseline_done_24),
//                        tint = green,
//                        contentDescription = "Success Icon"
//                    )
//                } else {
//                    IconButton(
//                        onClick = onDownloadClick,
//                        modifier = Modifier
//                            .size(36.dp)
//                            .align(Alignment.CenterEnd),
//                        content = {
//                            Icon(
//                                modifier = Modifier
//                                    .size(20.dp)
//                                    .align(Alignment.Center),
//                                painter = painterResource(id = R.drawable.ic_download),
//                                tint = black,
//                                contentDescription = "Download Icon"
//                            )
//                        }
//                    )
//                }
//            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RealTimeUpdateItemCard(realTimeUpdateItem = RealTimeUpdate.getMock(), onDownloadClick = {})
}




