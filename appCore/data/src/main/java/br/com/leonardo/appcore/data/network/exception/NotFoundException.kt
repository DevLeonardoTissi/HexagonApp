package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.NOT_FOUND_EXCEPTION_MESSAGE
import java.io.IOException

class NotFoundException(
    message: String = NOT_FOUND_EXCEPTION_MESSAGE,
) : IOException(message)
