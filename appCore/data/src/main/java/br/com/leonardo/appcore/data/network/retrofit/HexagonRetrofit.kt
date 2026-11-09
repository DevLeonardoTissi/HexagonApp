package br.com.leonardo.appcore.data.network.retrofit

import br.com.leonardo.appcore.data.network.config.OkHttpClientProviderConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HexagonRetrofit(
    private val okHttpClientProviderConfig: OkHttpClientProviderConfig,
) {
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
