package com.artemissoftware.amphitriteui.animation.automaticslider.models

import com.artemissoftware.amphitriteui.R

data class GodPicture(
    val title: String,
    val rating: Float,
    val desc: String,
    val img: Int
){

    companion object{

        val mockList = listOf(
            GodPicture(
                "Sample 1",
                4.0f,
                "Artemis 1",
                R.drawable.artemis_4
            ),
            GodPicture(
                "Sample 2",
                4.5f,
                "Artemis 2",
                R.drawable.artemis_6
            )
        )
    }

}