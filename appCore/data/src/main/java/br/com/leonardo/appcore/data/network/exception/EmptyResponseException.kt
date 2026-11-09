package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.EMPTY_RESPONSE_EXCEPTION_MESSAGE

class EmptyResponseException(
    message: String = EMPTY_RESPONSE_EXCEPTION_MESSAGE,
) : Exception(message)
