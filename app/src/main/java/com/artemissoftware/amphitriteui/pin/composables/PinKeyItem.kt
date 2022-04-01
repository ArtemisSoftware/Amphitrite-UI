package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.pin.PinScreen



@ExperimentalMaterialApi
@Composable
fun PinKeyItem(
    onPinClick: () -> Unit,
    modifier: Modifier = Modifier.padding(8.dp),
    shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = MaterialTheme.colors.onPrimary,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    elevation: Dp = 4.dp,
    content: @Composable () -> Unit
) {

    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        onClick = onPinClick,
        role = Role.Button,
        indication = rememberRipple()
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



@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PinKeyItem(

        onPinClick = {},
        content = {

        Text(
            text = "1",
            style = MaterialTheme.typography.h5
        )
    }
    )
}

