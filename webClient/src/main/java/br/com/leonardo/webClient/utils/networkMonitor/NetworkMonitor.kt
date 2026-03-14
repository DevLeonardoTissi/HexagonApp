package br.com.leonardo.webClient.utils.networkMonitor

import br.com.leonardo.webClient.utils.NetworkState

interface NetworkMonitor {
    fun monitor(
        onConnectionAvailable: (NetworkState.Available) -> Unit,
        onConnectionCapabilitiesChanged: (NetworkState) -> Unit,
        onConnectionLost: (NetworkState) -> Unit,
    )
}