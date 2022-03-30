package com.artemissoftware.amphitriteui.observeliveconnectivity.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.collapsebottomnavigation.BottomCollapseScreen
import com.artemissoftware.amphitriteui.ui.theme.green
import com.artemissoftware.amphitriteui.ui.theme.red

@Composable
fun ConnectivityStatusBox(
    isConnected: Boolean
) {
    val backgroundColor by animateColorAsState(targetValue = if (isConnected) green else red)
    val message = if (isConnected) "Back Online!" else "No Internet Connection!"
    val iconResource = if (isConnected) {
        R.drawable.ic_connectivity_available
    } else {
        R.drawable.ic_connectivity_unavailable
    }
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = "Connection Image",
                tint = Color.White
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = message,
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Column() {
        ConnectivityStatusBox(true)

        Spacer(modifier = Modifier.height(8.dp))
        ConnectivityStatusBox(false)
    }
}