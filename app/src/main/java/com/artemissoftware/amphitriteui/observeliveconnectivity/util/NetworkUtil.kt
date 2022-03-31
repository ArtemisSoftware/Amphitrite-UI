package com.artemissoftware.amphitriteui.observeliveconnectivity.util

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import com.artemissoftware.amphitriteui.observeliveconnectivity.models.ConnectionState

object NetworkUtil {

    fun networkConnectivityCallback(callback: (ConnectionState) -> Unit): ConnectivityManager.NetworkCallback {

        return object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                callback(ConnectionState.Available)
            }

            override fun onLost(network: Network) {
                callback(ConnectionState.Unavailable)
            }
        }
    }



    fun getCurrentConnectivityState(connectivityManager: ConnectivityManager) : ConnectionState {

        val connected = connectivityManager.allNetworks.any { network ->

            connectivityManager.getNetworkCapabilities(network)
                ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                ?: false
        }

        return if (connected) ConnectionState.Available else ConnectionState.Unavailable
    }
}