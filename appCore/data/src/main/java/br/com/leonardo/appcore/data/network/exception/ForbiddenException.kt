package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.FORBIDDEN_EXCEPTION_MESSAGE
import java.io.IOException

/**
 * Exception thrown when an HTTP 403 Forbidden response is received.
 *
 * @property message The detail message for the exception.
 */
class ForbiddenException(
    message: String = FORBIDDEN_EXCEPTION_MESSAGE,
) : IOException(message)
