package br.com.leonardo.appcore.data.network.utils

import android.net.Network
import android.net.NetworkCapabilities

/**
 * Sealed class representing network connection states and lifecycle events.
 */
sealed class NetworkState {
    /**
     * Represents a change in network capabilities.
     *
     * @property network The network instance.
     * @property networkCapabilities The updated [NetworkCapabilities].
     */
    data class CapabilitiesChanged(
        val network: Network,
        val networkCapabilities: NetworkCapabilities,
    ) : NetworkState()

    /**
     * Represents a network becoming available.
     *
     * @property network The available [Network].
     */
    data class Available(
        val network: Network,
    ) : NetworkState()

    /**
     * Represents the loss of network connection.
     */
    data object Lost : NetworkState()
}
