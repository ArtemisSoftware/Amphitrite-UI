package com.artemissoftware.amphitriteui.observeliveconnectivity.models

sealed class ConnectionState{
    object Available: ConnectionState()
    object Unavailable: ConnectionState()
}
