package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.pin.PinScreen

@Composable
fun PinKeyItem(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier.padding(8.dp),
//    shape: Shape = androidx.compose.material.MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = MaterialTheme.colors.onPrimary,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
//    elevation: Dp = 4.dp,
    content: @Composable () -> Unit
) {

    Surface(
//        modifier = modifier,
//        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
//        tonalElevation = elevation,
//        onClick = onClick,
//        role = Role.Button,
//        indication = rememberRipple()
    ) {
//        CompositionLocalProvider(
//            LocalContentAlpha provides contentColor.alpha
//        ) {
//            ProvideTextStyle(
//                MaterialTheme.typography.displayMedium
//            ) {
                Box(
                    modifier = Modifier
                        .defaultMinSize(minWidth = 64.dp, minHeight = 64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
//            }
//        }
    }
}



@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PinKeyItem(content = {
        Text(
            text = "1",
            style = MaterialTheme.typography.h5
        )
    })
}

