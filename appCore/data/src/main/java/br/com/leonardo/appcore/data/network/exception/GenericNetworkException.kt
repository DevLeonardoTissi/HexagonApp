package br.com.leonardo.appcore.data.network.exception

import java.io.IOException

/**
 * Exception thrown for generic network-related failures.
 *
 * @property message The detail message explaining the network failure.
 */
class GenericNetworkException(
    message: String,
) : IOException(message)
