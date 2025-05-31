package br.com.leonardo.webClient.utils.impl

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import br.com.leonardo.webClient.utils.NetworkMonitor
import br.com.leonardo.webClient.utils.NetworkState

class NetworkMonitorImpl(
    private val connectivityManager: ConnectivityManager
) : NetworkMonitor {

    override fun monitor(
        onConnectionAvailable: (NetworkState.Avaliable) -> Unit,
        onConnectionCapabilitiesChanged: (NetworkState) -> Unit,
        onConnectionLost: (NetworkState) -> Unit,
    ) {
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                onConnectionAvailable(NetworkState.Avaliable(network))
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                onConnectionCapabilitiesChanged(
                    NetworkState.CapabilitiesChanged(
                        network,
                        networkCapabilities
                    )
                )
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                onConnectionLost(NetworkState.Lost)
            }
        }

        connectivityManager.requestNetwork(networkRequest, networkCallback)
    }
}