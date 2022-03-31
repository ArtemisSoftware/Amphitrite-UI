package com.artemissoftware.amphitriteui.observeliveconnectivity.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import com.artemissoftware.amphitriteui.observeliveconnectivity.extensions.currentConnectivityState
import com.artemissoftware.amphitriteui.observeliveconnectivity.extensions.observeConnectivityAsFlow
import com.artemissoftware.amphitriteui.observeliveconnectivity.models.ConnectionState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged

@ExperimentalCoroutinesApi
@Composable
fun ConnectivityState(): State<ConnectionState> {
    val context = LocalContext.current
    return produceState(
        initialValue = context.currentConnectivityState
    ) {
        context.observeConnectivityAsFlow().distinctUntilChanged().collect { value = it }
    }
}
