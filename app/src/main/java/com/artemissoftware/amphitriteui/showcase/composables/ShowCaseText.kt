package com.artemissoftware.amphitriteui.showcase.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui.showcase.models.ShowCaseInfo

@Composable
fun ShowCaseText(
    currentTarget: ShowCaseInfo,
    boundsInParent: Rect,
    targetRadius: Float,
    onGloballyPositioned: (LayoutCoordinates) -> Unit
) {

    var txtOffsetY by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .offset(y = with(LocalDensity.current) {
                txtOffsetY.toDp()
            })
            .onGloballyPositioned {
                onGloballyPositioned(it)
                val textHeight = it.size.height
                val possibleTop = boundsInParent.center.y - targetRadius - textHeight

                txtOffsetY = if (possibleTop > 0) {
                    possibleTop
                } else {
                    boundsInParent.center.y + targetRadius
                }
            }
            .padding(16.dp)
    ) {
        Text(
            text = currentTarget.title,
            fontSize = 24.sp,
            color = currentTarget.titleColor,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = currentTarget.subTitle,
            fontSize = 16.sp,
            color = currentTarget.subTitleColor,
            fontWeight = FontWeight.Normal
        )
    }
}





