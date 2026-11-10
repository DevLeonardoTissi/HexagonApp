package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.SERVER_EXCEPTION_MESSAGE
import java.io.IOException

/**
 * Exception thrown when an HTTP 5xx Server error response is received.
 *
 * @property message The detail message for the exception.
 */
class ServerException(
    message: String = SERVER_EXCEPTION_MESSAGE,
) : IOException(message)
