package br.com.leonardo.appcore.data.network.connectivity

/**
 * Interface for checking current network connectivity status.
 */
interface NetworkStatus {
    /**
     * Checks whether the device currently has an active network connection with internet capability.
     *
     * @return `true` if connected to the internet, `false` otherwise.
     */
    fun isConnected(): Boolean
}
