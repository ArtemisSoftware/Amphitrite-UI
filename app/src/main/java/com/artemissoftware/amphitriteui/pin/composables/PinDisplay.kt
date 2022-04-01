package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.R

@Composable
fun PinDisplay() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.artemis_4),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Enter pin to unlock",
            style = typography.h6,
            modifier = Modifier.padding(16.dp),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

//        if (showSuccess.value) {
//            LottieLoadingView(
//                //context = context,
//                file = "success.json",
//                iterations = 1,
//                modifier = Modifier.size(100.dp)
//            )
//        } else {
//            Row {
//                (0 until pinSize).forEach {
//                    Icon(
//                        imageVector = if (inputPin.size > it) Icons.Default.Circle else Icons.Outlined.Circle,
//                        contentDescription = it.toString(),
//                        modifier = Modifier
//                            .padding(8.dp)
//                            .size(30.dp),
//                        tint = Color.Black
//                    )
//                }
//            }
//        }
//        Text(
//            text = error.value,
//            color = MaterialTheme.colorScheme.error,
//            modifier = Modifier.padding(16.dp)
//        )

        Spacer(modifier = Modifier.height(50.dp))
    }
}


@Preview(showBackground = true)
@Composable
private fun PinOptionRowPreview() {
    PinDisplay()
}