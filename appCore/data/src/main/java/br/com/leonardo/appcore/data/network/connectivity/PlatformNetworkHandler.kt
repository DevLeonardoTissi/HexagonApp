package br.com.leonardo.appcore.data.network.connectivity

import android.Manifest
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission

/**
 * Android platform implementation of [NetworkStatus] using [ConnectivityManager].
 *
 * @property connectivityManager The system [ConnectivityManager] service.
 */
class PlatformNetworkHandler(
    private val connectivityManager: ConnectivityManager,
) : NetworkStatus {
    /**
     * Checks whether the device currently has an active network connection with internet capability.
     * Requires [Manifest.permission.ACCESS_NETWORK_STATE].
     *
     * @return `true` if connected to the internet, `false` otherwise.
     */
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    @Suppress("ReturnCount")
    override fun isConnected(): Boolean {
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
