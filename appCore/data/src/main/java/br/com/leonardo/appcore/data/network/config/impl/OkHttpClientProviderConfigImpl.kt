package br.com.leonardo.appcore.data.network.config.impl

import br.com.leonardo.appcore.data.network.config.OkHttpClientProviderConfig
import br.com.leonardo.appcore.data.network.interceptor.ErrorInterceptor
import br.com.leonardo.appcore.data.network.interceptor.LoggingInterceptor
import br.com.leonardo.appcore.data.network.interceptor.NetworkStatusInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Implementation of [OkHttpClientProviderConfig] that sets up connection timeouts,
 * retry policies, and network interceptors.
 *
 * @property networkStatusInterceptor Interceptor for checking network connectivity before requests.
 * @property loggingInterceptor Interceptor for logging HTTP request and response data.
 * @property errorInterceptor Interceptor for handling HTTP error codes and responses.
 */
class OkHttpClientProviderConfigImpl(
    private val networkStatusInterceptor: NetworkStatusInterceptor,
    private val loggingInterceptor: LoggingInterceptor,
    private val errorInterceptor: ErrorInterceptor,
) : OkHttpClientProviderConfig {
    /**
     * Builds and returns a fully configured [OkHttpClient].
     *
     * @return [OkHttpClient] with custom timeouts, connection failure retry, and interceptors.
     */
    override operator fun invoke(): OkHttpClient =
        OkHttpClient
            .Builder()
            .apply {
                connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                retryOnConnectionFailure(true)
                addInterceptor(networkStatusInterceptor)
                addInterceptor(loggingInterceptor)
                addInterceptor(errorInterceptor)
            }.build()
}

/** Connection timeout duration in seconds. */
private const val CONNECTION_TIMEOUT = 60L

/** Read timeout duration in seconds. */
private const val READ_TIMEOUT = 60L

/** Write timeout duration in seconds. */
private const val WRITE_TIMEOUT = 60L
