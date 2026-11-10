package br.com.leonardo.appcore.data.network.retrofit

import br.com.leonardo.appcore.data.network.config.OkHttpClientProviderConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Factory class for creating Retrofit API service instances using configured OkHttpClient and Gson converter.
 *
 * @property okHttpClientProviderConfig Provider for configured [okhttp3.OkHttpClient] instances.
 */
class HexagonRetrofit(
    private val okHttpClientProviderConfig: OkHttpClientProviderConfig,
) {
    /**
     * Creates and returns a Retrofit service implementation for the given service interface.
     *
     * @param T The service interface type.
     * @param baseUrl The base URL for the API.
     * @param serviceClass The Class object of the service interface.
     * @return An implementation of the requested service interface.
     */
    fun <T> createService(
        baseUrl: String,
        serviceClass: Class<T>,
    ): T =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClientProviderConfig())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceClass)
}
