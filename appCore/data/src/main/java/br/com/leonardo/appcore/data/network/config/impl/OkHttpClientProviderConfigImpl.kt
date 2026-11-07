package br.com.leonardo.webClient.config.impl

import br.com.leonardo.webClient.config.OkHttpClientProviderConfig
import br.com.leonardo.webClient.interceptor.ErrorInterceptor
import br.com.leonardo.webClient.interceptor.LoggingInterceptor
import br.com.leonardo.webClient.interceptor.NetworkStatusInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientProviderConfigImpl(
    private val networkStatusInterceptor: NetworkStatusInterceptor,
    private val loggingInterceptor: LoggingInterceptor,
    private val errorInterceptor: ErrorInterceptor

) : OkHttpClientProviderConfig {

    override operator fun invoke(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(networkStatusInterceptor)
            addInterceptor(loggingInterceptor)
            addInterceptor(errorInterceptor)
        }.build()
    }
}

private const val CONNECTION_TIMEOUT = 60L
private const val READ_TIMEOUT = 60L
private const val WRITE_TIMEOUT = 60L
