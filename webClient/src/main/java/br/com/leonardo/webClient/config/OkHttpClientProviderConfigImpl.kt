package br.com.leonardo.webClient.config

import br.com.leonardo.webClient.connectivity.NetworkStatus
import br.com.leonardo.webClient.interceptor.NetworkStatusInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpClientProviderConfigImpl(private val networkStatus: NetworkStatus) :
    OkHttpClientProviderConfig {

    override operator fun invoke(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .apply {
                addInterceptor(NetworkStatusInterceptor(networkStatus))
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()
    }
}
