package br.com.leonardo.webClient.interceptor.impl

import br.com.leonardo.webClient.exception.ForbiddenException
import br.com.leonardo.webClient.exception.GenericNetworkException
import br.com.leonardo.webClient.exception.NotFoundException
import br.com.leonardo.webClient.exception.ServerException
import br.com.leonardo.webClient.exception.UnauthorizedException
import br.com.leonardo.webClient.interceptor.ErrorInterceptor
import okhttp3.Interceptor
import okhttp3.Response

class ErrorInterceptorImpl : ErrorInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (!response.isSuccessful) {
            when (response.code) {
                401 -> throw UnauthorizedException()
                403 -> throw ForbiddenException()
                404 -> throw NotFoundException()
                in 500..599 -> throw ServerException()
                else -> throw GenericNetworkException("Error ${response.code}: ${response.message}")
            }
        }

        return response
    }
}
