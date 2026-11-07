package br.com.leonardo.webClient.exception

import br.com.leonardo.webClient.utils.NOT_FOUND_EXCEPTION_MESSAGE
import java.io.IOException

class NotFoundException(message: String = NOT_FOUND_EXCEPTION_MESSAGE) :
    IOException(message)
