package com.artemissoftware.amphitriteui.realtimelifecycleupdate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.composables.CurrencyCard
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.composables.RealTimeLifecycleUpdatePriceCard
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.CurrencyPrice
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.PriceFluctuation

@Composable
fun RealTimeLifecycleUpdateScreen() {

    val viewModel: RealTimeLifecycleUpdateViewModel = viewModel()
    val currencyPrices = viewModel.currencyPrices.collectAsState()

    LazyColumn {
        itemsIndexed(currencyPrices.value, { _, item -> item.id }) { index, currencyPrice ->

            RealTimeLifecycleUpdatePriceCard(
                currencyPrice = currencyPrice,
                currencyPriceUpdateFlow = viewModel.provideCurrencyUpdateFlow(),
                onDisposed = { viewModel.onDisposed(index) },
                onCurrencyUpdated = { newPrice -> viewModel.onCurrencyUpdated(newPrice, index) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RealTimeLifecycleUpdateScreen()
}