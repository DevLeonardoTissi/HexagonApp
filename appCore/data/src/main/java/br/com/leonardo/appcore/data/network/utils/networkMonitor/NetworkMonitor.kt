package br.com.leonardo.appcore.data.network.utils.networkMonitor

import br.com.leonardo.appcore.data.network.utils.NetworkState

interface NetworkMonitor {
    fun monitor(
        onConnectionAvailable: (NetworkState.Available) -> Unit,
        onConnectionCapabilitiesChanged: (NetworkState) -> Unit,
        onConnectionLost: (NetworkState) -> Unit,
    )
}
