package br.com.leonardo.appcore.data.network.interceptor.impl

import br.com.leonardo.appcore.data.network.connectivity.NetworkStatus
import br.com.leonardo.appcore.data.network.exception.NetworkException
import br.com.leonardo.appcore.data.network.interceptor.NetworkStatusInterceptor
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Implementation of [NetworkStatusInterceptor] that checks network connectivity
 * via [NetworkStatus] before proceeding with HTTP requests, throwing [NetworkException] if offline.
 *
 * @property networkStatus Utility to verify network connectivity.
 */
class NetworkStatusInterceptorImpl(
    private val networkStatus: NetworkStatus,
) : NetworkStatusInterceptor {
    /**
     * Intercepts network requests, ensuring the device is connected to the internet.
     *
     * @param chain The interception chain.
     * @return The network [Response].
     * @throws NetworkException if the device is offline.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkStatus.isConnected()) {
            throw NetworkException()
        } else {
            return chain.proceed(chain.request().newBuilder().build())
        }
    }
}
