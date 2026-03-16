package br.com.leonardo.webClient.exception

import br.com.leonardo.webClient.utils.EMPTY_RESPONSE_EXCEPTION_MESSAGE

class EmptyResponseException(message: String = EMPTY_RESPONSE_EXCEPTION_MESSAGE) :
    Exception(message)