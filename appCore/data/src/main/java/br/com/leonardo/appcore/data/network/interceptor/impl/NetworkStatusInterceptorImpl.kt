package br.com.leonardo.appcore.data.network.interceptor.impl

import br.com.leonardo.appcore.data.network.connectivity.NetworkStatus
import br.com.leonardo.appcore.data.network.exception.NetworkException
import br.com.leonardo.appcore.data.network.interceptor.NetworkStatusInterceptor
import okhttp3.Interceptor
import okhttp3.Response

class NetworkStatusInterceptorImpl(
    private val networkStatus: NetworkStatus,
) : NetworkStatusInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkStatus.isConnected()) {
            throw NetworkException()
        } else {
            return chain.proceed(chain.request().newBuilder().build())
        }
    }
}
