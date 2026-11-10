package br.com.leonardo.appcore.data.network.interceptor.impl

import br.com.leonardo.appcore.data.network.exception.ForbiddenException
import br.com.leonardo.appcore.data.network.exception.GenericNetworkException
import br.com.leonardo.appcore.data.network.exception.NotFoundException
import br.com.leonardo.appcore.data.network.exception.ServerException
import br.com.leonardo.appcore.data.network.exception.UnauthorizedException
import br.com.leonardo.appcore.data.network.interceptor.ErrorInterceptor
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Implementation of [ErrorInterceptor] that inspects HTTP response codes
 * and throws appropriate domain exceptions (e.g., [UnauthorizedException], [ServerException]).
 */
@Suppress("ThrowsCount")
class ErrorInterceptorImpl : ErrorInterceptor {
    /**
     * Intercepts outgoing requests and evaluates response status codes.
     *
     * @param chain The interception chain.
     * @return The successful [Response].
     * @throws UnauthorizedException on HTTP 401.
     * @throws ForbiddenException on HTTP 403.
     * @throws NotFoundException on HTTP 404.
     * @throws ServerException on HTTP 5xx.
     * @throws GenericNetworkException on other error codes.
     */
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

/** HTTP 401 Unauthorized status code. */
private const val HTTP_UNAUTHORIZED = 401

/** HTTP 403 Forbidden status code. */
private const val HTTP_FORBIDDEN = 403

/** HTTP 404 Not Found status code. */
private const val HTTP_NOT_FOUND = 404

/** Start of HTTP 5xx server error range. */
private const val HTTP_SERVER_ERROR_START = 500

/** End of HTTP 5xx server error range. */
private const val HTTP_SERVER_ERROR_END = 599
