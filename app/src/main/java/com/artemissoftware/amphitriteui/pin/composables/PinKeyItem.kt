package com.artemissoftware.amphitriteui.pin.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui.pin.PinScreen

@Composable
fun PinKeyItem() {

    Surface(
//        modifier = modifier,
//        shape = shape,
//        color = backgroundColor,
//        contentColor = contentColor,
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
//                    content()
                }
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    PinKeyItem()
}