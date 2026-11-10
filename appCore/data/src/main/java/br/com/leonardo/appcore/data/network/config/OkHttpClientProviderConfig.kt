package br.com.leonardo.appcore.data.network.config

import okhttp3.OkHttpClient

/**
 * Interface defining a provider for configured [OkHttpClient] instances.
 */
interface OkHttpClientProviderConfig {
    /**
     * Provides a configured [OkHttpClient] instance.
     *
     * @return [OkHttpClient] configured with timeouts and interceptors.
     */
    operator fun invoke(): OkHttpClient
}
