package br.com.leonardo.webClient.utils

interface NetworkMonitor {
    fun monitor(
        onConnectionAvailable: (NetworkState.Avaliable) -> Unit,
        onConnectionCapabilitiesChanged: (NetworkState) -> Unit,
        onConnectionLost: (NetworkState) -> Unit,
    )
}