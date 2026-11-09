package br.com.leonardo.appcore.data.network.interceptor.impl

import br.com.leonardo.appcore.data.BuildConfig
import br.com.leonardo.appcore.data.network.interceptor.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorImpl : LoggingInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        HttpLoggingInterceptor()
            .apply {
                level =
                    if (BuildConfig.ENABLE_HTTP_LOG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
            }.intercept(chain)
}
