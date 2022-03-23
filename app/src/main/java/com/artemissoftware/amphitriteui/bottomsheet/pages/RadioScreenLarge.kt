package com.artemissoftware.amphitriteui.bottomsheet.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Radio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.artemissoftware.amphitriteui.R
import com.artemissoftware.amphitriteui.bottomsheet.composables.PlayerControls
import com.artemissoftware.amphitriteui.ui.theme.Purple500

@Preview(showBackground = true)
@Composable
fun RadioScreenLarge() {
    Surface {
        RadioPlayer(
            topSection = {
                TopSection()
            },
            playerControls = {
                PlayerControls()
            }
        )
    }
}


@Composable
private fun RadioPlayer(
    topSection: @Composable () -> Unit,
    playerControls: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .background(Purple500)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 35.dp)
            ) {
                topSection()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
        ) {
            Spacer(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStartPercent = 100,
                            bottomEndPercent = 100
                        )
                    )
                    .background(Purple500)
                    .height(35.dp)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 35.dp),
                contentAlignment = Alignment.Center
            ) {
                playerControls()
            }
        }
    }
}


@Preview
@Composable
private fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RadioLogo()

        Text(
            text = "FM Title / Make it Easy",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(15.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 15.sp
        )
    }
}


@Preview
@Composable
fun RadioLogo() {
    val painter = rememberImagePainter(
        data = R.drawable.ic_baseline_radio_24,
        builder = {
            crossfade(true)
        },
        onExecute = { _, _-> true }
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(250.dp)
            .shadow(30.dp, CircleShape)
            .background(
                color = Color.LightGray,
                shape = CircleShape
            )
            .border(10.dp, Purple500, CircleShape)
    ) {
        Image(
            painter = painter,
            contentDescription = "Radio",
            modifier = Modifier
                .size(150.dp)
                .padding(15.dp)
        )

        when (painter.state) {
            is ImagePainter.State.Error -> {
                Icon(
                    imageVector = Icons.Filled.Radio,
                    contentDescription = "Radio",
                    tint = Purple500,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}