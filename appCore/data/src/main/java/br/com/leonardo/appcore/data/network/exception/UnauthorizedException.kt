package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.UNAUTHORIZED_EXCEPTION_MESSAGE
import java.io.IOException

/**
 * Exception thrown when an HTTP 401 Unauthorized response is received.
 *
 * @property message The detail message for the exception.
 */
class UnauthorizedException(
    message: String = UNAUTHORIZED_EXCEPTION_MESSAGE,
) : IOException(message)
