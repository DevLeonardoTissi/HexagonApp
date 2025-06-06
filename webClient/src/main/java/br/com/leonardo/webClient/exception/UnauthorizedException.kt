package br.com.leonardo.webClient.exception

import br.com.leonardo.webClient.utils.UNAUTHORIZED_EXCEPTION_MESSAGE
import java.io.IOException

class UnauthorizedException(message: String = UNAUTHORIZED_EXCEPTION_MESSAGE) :
    IOException(message)