package br.com.leonardo.appcore.data.network.interceptor.impl

import br.com.leonardo.appcore.data.network.exception.ForbiddenException
import br.com.leonardo.appcore.data.network.exception.GenericNetworkException
import br.com.leonardo.appcore.data.network.exception.NotFoundException
import br.com.leonardo.appcore.data.network.exception.ServerException
import br.com.leonardo.appcore.data.network.exception.UnauthorizedException
import br.com.leonardo.appcore.data.network.interceptor.ErrorInterceptor
import okhttp3.Interceptor
import okhttp3.Response

@Suppress("ThrowsCount")
class ErrorInterceptorImpl : ErrorInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (!response.isSuccessful) {
            when (response.code) {
                HTTP_UNAUTHORIZED -> throw UnauthorizedException()
                HTTP_FORBIDDEN -> throw ForbiddenException()
                HTTP_NOT_FOUND -> throw NotFoundException()
                in HTTP_SERVER_ERROR_START..HTTP_SERVER_ERROR_END -> throw ServerException()
                else -> throw GenericNetworkException("Error ${response.code}: ${response.message}")
            }
        }

        return response
    }
}

private const val HTTP_UNAUTHORIZED = 401
private const val HTTP_FORBIDDEN = 403
private const val HTTP_NOT_FOUND = 404
private const val HTTP_SERVER_ERROR_START = 500
private const val HTTP_SERVER_ERROR_END = 599
