package br.com.leonardo.webClient.interceptor.impl

import br.com.leonardo.webClient.BuildConfig
import br.com.leonardo.webClient.interceptor.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorImpl : LoggingInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.ENABLE_HTTP_LOG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }.intercept(chain)
    }
}