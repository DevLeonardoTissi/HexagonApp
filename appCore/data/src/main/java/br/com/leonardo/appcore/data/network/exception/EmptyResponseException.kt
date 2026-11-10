package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.EMPTY_RESPONSE_EXCEPTION_MESSAGE

/**
 * Exception thrown when a network response body is unexpectedly empty.
 *
 * @property message The detail message for the exception.
 */
class EmptyResponseException(
    message: String = EMPTY_RESPONSE_EXCEPTION_MESSAGE,
) : Exception(message)
