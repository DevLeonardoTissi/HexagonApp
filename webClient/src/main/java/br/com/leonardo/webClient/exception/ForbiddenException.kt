package br.com.leonardo.webClient.exception

import br.com.leonardo.webClient.utils.FORBIDDEN_EXCEPTION_MESSAGE
import java.io.IOException

class ForbiddenException(message: String = FORBIDDEN_EXCEPTION_MESSAGE) :
    IOException(message)
