package br.com.leonardo.webClient.exception

import br.com.leonardo.webClient.utils.SERVER_EXCEPTION_MESSAGE
import java.io.IOException

class ServerException(message: String = SERVER_EXCEPTION_MESSAGE) :
    IOException(message)
