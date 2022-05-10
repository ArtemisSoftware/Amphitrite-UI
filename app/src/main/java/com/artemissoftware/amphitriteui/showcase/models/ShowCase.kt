package com.artemissoftware.amphitriteui.showcase.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates

data class ShowCase(
    val index: Int,
    //val coordinate: LayoutCoordinates,
    val title: String,
    val subTitle: String,
    val titleColor: Color = Color.White,
    val subTitleColor: Color = Color.White
){

    companion object{

        fun getMock() = ShowCase(
                index = 1,
                title = "The title",
                subTitle = "the subtitle",
                titleColor = Color.Green,
                subTitleColor = Color.Red
            )

    }

}