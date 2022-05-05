package com.artemissoftware.amphitriteui.realtimeupdate.model

data class RealTimeUpdate(
    val id: Int,
    val title: String,
    val downloadProgress: Int
){

    companion object{

        fun getMock() =  RealTimeUpdate(id = 1, title = "The first title", downloadProgress = 10)

    }

}
