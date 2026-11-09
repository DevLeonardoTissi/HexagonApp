package br.com.leonardo.appcore.data.network.config

import okhttp3.OkHttpClient

interface OkHttpClientProviderConfig {
    operator fun invoke(): OkHttpClient
}
