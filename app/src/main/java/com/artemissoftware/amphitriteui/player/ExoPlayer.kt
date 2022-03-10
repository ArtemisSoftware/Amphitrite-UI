package com.artemissoftware.amphitriteui.player

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme
import com.artemissoftware.amphitriteui.util.Constants.VIDEO_URL
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

//@SuppressLint("RememberReturnType")
@Composable
fun ExoPlayer(
    url: String
) {

    val context = LocalContext.current

    val exoPlayer = remember(context) {

        SimpleExoPlayer
            .Builder(context)
            .build().apply {

                val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
                    context, Util.getUserAgent(context, context.packageName)
                )

                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(Uri.parse(url))

            this.prepare(source)
        }
    }


    AndroidView(
        factory = { context ->
            PlayerView(context).apply {
                player = exoPlayer
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExoPlayer(url = VIDEO_URL)
}