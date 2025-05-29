package br.com.leonardo.webClient.interceptor.impl

import br.com.leonardo.webClient.connectivity.NetworkStatus
import br.com.leonardo.webClient.exception.NetworkException
import br.com.leonardo.webClient.interceptor.NetworkStatusInterceptor
import okhttp3.Interceptor
import okhttp3.Response

class NetworkStatusInterceptorImpl(private val networkStatus: NetworkStatus) :
    NetworkStatusInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkStatus.isConnected()) {
            throw NetworkException()
        } else {
            return chain.proceed(chain.request().newBuilder().build())
        }
    }
}