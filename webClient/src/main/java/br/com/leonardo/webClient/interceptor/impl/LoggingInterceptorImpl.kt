package br.com.leonardo.webClient.interceptor.impl

import br.com.leonardo.webClient.interceptor.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorImpl : LoggingInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }.intercept(chain)
    }
}