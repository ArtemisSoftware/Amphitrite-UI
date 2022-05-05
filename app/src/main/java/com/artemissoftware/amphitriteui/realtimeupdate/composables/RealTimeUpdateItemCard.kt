package com.artemissoftware.amphitriteui.realtimeupdate.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.realtimeupdate.model.RealTimeUpdate

@Composable
fun RealTimeUpdateItemCard(
    realTimeUpdateItem: RealTimeUpdate,
    onDownloadClick: () -> Unit
) {

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
                text = realTimeUpdateItem.title,
                modifier = Modifier.padding(16.dp),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            DownloadProgress(
                modifier = Modifier.weight(1f),
                realTimeUpdateItem = realTimeUpdateItem,
                onDownloadClick = onDownloadClick

            )

        }
    }
}

@Composable
private fun DownloadProgress(
    modifier: Modifier = Modifier,
    realTimeUpdateItem: RealTimeUpdate,
    onDownloadClick: () -> Unit
) {

    val isDownloaded = realTimeUpdateItem.downloadProgress == 100
    val animatedProgress: Float by animateFloatAsState(targetValue = realTimeUpdateItem.downloadProgress / 100f)

    Box(
        modifier = modifier
            .height(56.dp)
            .padding(horizontal = 16.dp)

    ) {
        CircularProgressIndicator(
            strokeWidth = 2.dp,
            modifier = Modifier
                .size(36.dp)
                .align(Alignment.CenterEnd),
            progress = animatedProgress,
            color = if (isDownloaded) Color.Green else Color.Black
        )


        if (isDownloaded) {
            Icon(
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
                    .align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.ic_baseline_done_24),
                tint = Color.Green,
                contentDescription = "Success Icon"
            )
        } else {
            IconButton(
                onClick = onDownloadClick,
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.CenterEnd),
                content = {
                    Icon(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_download),
                        tint = Color.Black,
                        contentDescription = "Download Icon"
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DownloadProgressPreview() {
    DownloadProgress(
        realTimeUpdateItem = RealTimeUpdate.getMock(), onDownloadClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Column {
        RealTimeUpdateItemCard(realTimeUpdateItem = RealTimeUpdate.getMock(), onDownloadClick = {})
        RealTimeUpdateItemCard(realTimeUpdateItem = RealTimeUpdate.getMock(50), onDownloadClick = {})
        RealTimeUpdateItemCard(realTimeUpdateItem = RealTimeUpdate.getMock(100), onDownloadClick = {})
    }

}




