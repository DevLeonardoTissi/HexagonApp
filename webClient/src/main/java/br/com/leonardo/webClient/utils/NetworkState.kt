package br.com.leonardo.webClient.utils

import android.net.Network
import android.net.NetworkCapabilities

sealed class NetworkState {

    data class CapabilitiesChanged(
        val network: Network,
        val networkCapabilities: NetworkCapabilities
    ) : NetworkState()

    data class Available(val network: Network) : NetworkState()
    data object Lost : NetworkState()

}