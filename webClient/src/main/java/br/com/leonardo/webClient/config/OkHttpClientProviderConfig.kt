package br.com.leonardo.webClient.config

import okhttp3.OkHttpClient

interface OkHttpClientProviderConfig {

    operator fun invoke(): OkHttpClient
}