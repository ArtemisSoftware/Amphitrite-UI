package com.artemissoftware.amphitriteui.observeliveconnectivity

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.Greeting
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.observeliveconnectivity.composable.ConnectivityStatus
import com.artemissoftware.amphitriteui.ui.theme.AmphitriteUITheme

@ExperimentalAnimationApi
@Composable
fun ConnectivityScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        ConnectivityStatus()
        Image(
            painter = painterResource(id = R.drawable.artemis_4),
            contentDescription = "Image",
            modifier = Modifier.size(400.dp)
                .align(alignment = Alignment.Center)
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ConnectivityScreen()
}