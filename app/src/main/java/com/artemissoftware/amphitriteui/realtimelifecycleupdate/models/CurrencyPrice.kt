package com.artemissoftware.amphitriteui.realtimelifecycleupdate.models

import androidx.compose.runtime.Immutable

@Immutable
data class CurrencyPrice(
    val id: Int,
    val name: String,
    val price: Int,
    val priceFluctuation: PriceFluctuation
)