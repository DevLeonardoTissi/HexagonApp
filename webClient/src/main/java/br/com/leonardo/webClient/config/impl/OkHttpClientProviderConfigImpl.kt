package br.com.leonardo.webClient.config.impl

import br.com.leonardo.webClient.config.OkHttpClientProviderConfig
import br.com.leonardo.webClient.interceptor.LoggingInterceptor
import br.com.leonardo.webClient.interceptor.NetworkStatusInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientProviderConfigImpl(
    private val networkStatusInterceptor: NetworkStatusInterceptor,
    private val loggingInterceptor: LoggingInterceptor
) :
    OkHttpClientProviderConfig {

    override operator fun invoke(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(networkStatusInterceptor)
            addInterceptor(loggingInterceptor)
        }.build()
    }
}
