package br.com.leonardo.appcore.data.network.utils.networkMonitor

import br.com.leonardo.appcore.data.network.utils.NetworkState

/**
 * Interface for monitoring network connectivity changes and availability.
 */
interface NetworkMonitor {
    /**
     * Starts monitoring network connectivity states.
     *
     * @param onConnectionAvailable Callback invoked when a network connection becomes available.
     * @param onConnectionCapabilitiesChanged Callback invoked when network capabilities change.
     * @param onConnectionLost Callback invoked when network connection is lost.
     */
    fun monitor(
        onConnectionAvailable: (NetworkState.Available) -> Unit,
        onConnectionCapabilitiesChanged: (NetworkState) -> Unit,
        onConnectionLost: (NetworkState) -> Unit,
    )
}
