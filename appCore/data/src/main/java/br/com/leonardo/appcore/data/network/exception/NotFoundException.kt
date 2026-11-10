package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.NOT_FOUND_EXCEPTION_MESSAGE
import java.io.IOException

/**
 * Exception thrown when an HTTP 404 Not Found response is received.
 *
 * @property message The detail message for the exception.
 */
class NotFoundException(
    message: String = NOT_FOUND_EXCEPTION_MESSAGE,
) : IOException(message)
