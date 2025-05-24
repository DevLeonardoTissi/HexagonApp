package br.com.leonardo.webClient.interceptor

import br.com.leonardo.webClient.connectivity.NetworkStatus
import br.com.leonardo.webClient.exception.NetworkException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkStatusInterceptor(private val networkStatus: NetworkStatus) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkStatus.isConnected()) {
            throw NetworkException()
        } else {
            return chain.proceed(chain.request().newBuilder().build())
        }
    }
}