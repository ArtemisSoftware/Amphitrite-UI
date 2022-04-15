package com.artemissoftware.amphitriteui.util

enum class Language(val language: String, val abreviation: String, val position : Int) {

    ENGLISH(language = "English",  abreviation = "en", position = 0),
    ITALIAN(language = "Italian",  abreviation = "it", position = 1);


    companion object {
        fun get(position: Int) = values()[position]
    }

}