package com.artemissoftware.amphitriteui.realtimelifecycleupdate.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.CurrencyPrice
import com.artemissoftware.amphitriteui.realtimelifecycleupdate.models.PriceFluctuation

@Composable
fun RealTimeLifecycleUpdatePriceCard(
    currencyPrice: CurrencyPrice,
//    currencyPriceUpdateFlow: Flow<Int>,
//    onCurrencyUpdated: (progress: Int) -> Unit,
//    onDisposed: () -> Unit,
) {

//    val lifecycleOwner = LocalLifecycleOwner.current
//    val lifecycleAwareCurrencyPriceFlow = remember(currencyPriceUpdateFlow, lifecycleOwner) {
//        currencyPriceUpdateFlow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
//    }
//
//    LaunchedEffect(Unit) {
//        lifecycleAwareCurrencyPriceFlow.collect { progress -> onCurrencyUpdated(progress) }
//    }
//    DisposableEffect(Unit) { onDispose { onDisposed() } }

    CurrencyCard(currencyPrice.name, "${currencyPrice.price}", currencyPrice.priceFluctuation)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RealTimeLifecycleUpdatePriceCard(
        currencyPrice = CurrencyPrice.getMocks()[0]
    )
}