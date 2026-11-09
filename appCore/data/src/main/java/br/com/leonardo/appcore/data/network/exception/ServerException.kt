package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.SERVER_EXCEPTION_MESSAGE
import java.io.IOException

class ServerException(
    message: String = SERVER_EXCEPTION_MESSAGE,
) : IOException(message)
