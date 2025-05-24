package br.com.leonardo.hexagonapp.utils

import android.net.Network
import android.net.NetworkCapabilities

sealed class NetworkState {

    data class CapabilitiesChanged(
        val network: Network,
        val natworkCapabilities: NetworkCapabilities
    ) : NetworkState()

    data class Avaliable(val network: Network) : NetworkState()
    data object Lost : NetworkState()

}