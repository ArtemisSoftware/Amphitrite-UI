package com.artemissoftware.amphitriteui.observeliveconnectivity.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.artemissoftware.amphitriteui.observeliveconnectivity.models.ConnectionState
import com.artemissoftware.amphitriteui.observeliveconnectivity.util.NetworkUtil.getCurrentConnectivityState
import com.artemissoftware.amphitriteui.observeliveconnectivity.util.NetworkUtil.networkConnectivityCallback
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged

@ExperimentalCoroutinesApi
fun Context.observeConnectivityAsFlow() = callbackFlow {

    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val callback = networkConnectivityCallback { connectionState -> trySend(connectionState)}

    val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .build()

    connectivityManager.registerNetworkCallback(networkRequest, callback)

    trySend(getCurrentConnectivityState(connectivityManager))

    awaitClose {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}

val Context.currentConnectivityState: ConnectionState
    get() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return getCurrentConnectivityState(connectivityManager)
    }
