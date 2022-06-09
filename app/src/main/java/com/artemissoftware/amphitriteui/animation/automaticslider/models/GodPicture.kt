package com.artemissoftware.amphitriteui.animation.automaticslider.models

data class GodPicture(
    val title: String,
    val rating: Float,
    val desc: String,
    val imgUrl: String
){

    companion object{

        val mockList = listOf(
            GodPicture(
                "Sample 1",
                4.0f,
                "Artemis 1",
                ""
            ),
            GodPicture(
                "Sample 2",
                4.5f,
                "Artemis 2",
                ""
            )
        )
    }

}