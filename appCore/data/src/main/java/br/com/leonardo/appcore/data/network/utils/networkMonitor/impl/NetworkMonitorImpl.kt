package br.com.leonardo.appcore.data.network.utils.networkMonitor.impl

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import br.com.leonardo.appcore.data.network.utils.NetworkState
import br.com.leonardo.appcore.data.network.utils.networkMonitor.NetworkMonitor

class NetworkMonitorImpl(
    private val connectivityManager: ConnectivityManager,
) : NetworkMonitor {
    override fun monitor(
        onConnectionAvailable: (NetworkState.Available) -> Unit,
        onConnectionCapabilitiesChanged: (NetworkState) -> Unit,
        onConnectionLost: (NetworkState) -> Unit,
    ) {
        val networkRequest =
            NetworkRequest
                .Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .build()

        val networkCallback =
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    onConnectionAvailable(NetworkState.Available(network))
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities,
                ) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    onConnectionCapabilitiesChanged(
                        NetworkState.CapabilitiesChanged(
                            network,
                            networkCapabilities,
                        ),
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
