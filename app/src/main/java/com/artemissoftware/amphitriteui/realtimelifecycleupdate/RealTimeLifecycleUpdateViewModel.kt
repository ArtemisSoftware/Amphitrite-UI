package com.artemissoftware.amphitriteui.realtimelifecycleupdate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.CurrencyPrice
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.PriceFluctuation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random


class RealTimeLifecycleUpdateViewModel : ViewModel() {

    private val _currencyPrices = MutableStateFlow(listOf<CurrencyPrice>())
    val currencyPrices: StateFlow<List<CurrencyPrice>> get() = _currencyPrices


    init {
        getCurrencyPrices()
    }

    private fun getCurrencyPrices() {
        viewModelScope.launch(Dispatchers.Default) {

            val initialCurrencyPrices = arrayListOf<CurrencyPrice>()

            run loop@{
                Currency.getAvailableCurrencies().forEachIndexed { index, currency ->

                    if (index == 100) return@loop

                    initialCurrencyPrices += CurrencyPrice(
                        id = index,
                        name = "1 USD to ${currency.currencyCode}",
                        price = Random.nextInt(0, 100),
                        priceFluctuation = PriceFluctuation.UNKNOWN
                    )
                }
            }

            _currencyPrices.emit(initialCurrencyPrices)
        }
    }

    fun onCurrencyUpdated(newPrice: Int, index: Int) {
        val newFluctuation = when {
            newPrice > _currencyPrices.value[index].price -> PriceFluctuation.UP
            else -> PriceFluctuation.DOWN
        }
        val updatedCurrency =
            _currencyPrices.value[index].copy(price = newPrice, priceFluctuation = newFluctuation)
        val mutableCurrencies = _currencyPrices.value.toMutableList()
        mutableCurrencies[index] = updatedCurrency
        _currencyPrices.value = mutableCurrencies.toList()
    }

    fun onDisposed(index: Int) {
        val updatedCurrency =
            _currencyPrices.value[index].copy(priceFluctuation = PriceFluctuation.UNKNOWN)
        val mutableCurrencies = _currencyPrices.value.toMutableList()
        mutableCurrencies[index] = updatedCurrency
        _currencyPrices.value = mutableCurrencies.toList()
    }

    fun provideCurrencyUpdateFlow(): Flow<Int> {
        return flow {
            repeat(10000) {
                delay(Random.nextLong(500L, 2500L))
                emit(Random.nextInt(0, 100))
            }
        }.flowOn(Dispatchers.Default).distinctUntilChanged()
    }
}
