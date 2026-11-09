package br.com.leonardo.appcore.data.network.exception

import java.io.IOException

class GenericNetworkException(
    message: String,
) : IOException(message)
