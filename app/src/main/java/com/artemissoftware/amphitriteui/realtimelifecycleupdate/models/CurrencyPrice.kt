package com.artemissoftware.amphitriteui.realtimelifecycleupdate.models

import androidx.compose.runtime.Immutable

@Immutable
data class CurrencyPrice(
    val id: Int,
    val name: String,
    val price: Int,
    val priceFluctuation: PriceFluctuation
){

    companion object{

        fun getMocks() = listOf(
            CurrencyPrice(
                id = 1,
                name = "Name 1",
                price = 1000,
                priceFluctuation = PriceFluctuation.DOWN
            ),
            CurrencyPrice(
                id = 2,
                name = "Name 2",
                price = 2000,
                priceFluctuation = PriceFluctuation.UNKNOWN
            ),
            CurrencyPrice(
                id = 3,
                name = "Name 3",
                price = 3000,
                priceFluctuation = PriceFluctuation.UP
            )
        )
    }


}