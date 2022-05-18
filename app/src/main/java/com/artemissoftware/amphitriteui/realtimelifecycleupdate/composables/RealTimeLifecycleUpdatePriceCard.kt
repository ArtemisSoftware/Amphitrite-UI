package com.artemissoftware.amphitriteui.realtimelifecycleupdate.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.CurrencyPrice
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.PriceFluctuation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

@Composable
fun RealTimeLifecycleUpdatePriceCard(
    currencyPrice: CurrencyPrice,
    currencyPriceUpdateFlow: Flow<Int>,
    onCurrencyUpdated: (progress: Int) -> Unit,
    onDisposed: () -> Unit,
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleAwareCurrencyPriceFlow = remember(currencyPriceUpdateFlow, lifecycleOwner) {
        currencyPriceUpdateFlow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }

    LaunchedEffect(Unit) {
        lifecycleAwareCurrencyPriceFlow.collect { progress -> onCurrencyUpdated(progress) }
    }
    DisposableEffect(Unit) { onDispose { onDisposed() } }

    CurrencyCard(currencyPrice.name, "${currencyPrice.price}", currencyPrice.priceFluctuation)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
//    RealTimeLifecycleUpdatePriceCard(
//        currencyPrice = CurrencyPrice.getMocks()[0]
//    )
}