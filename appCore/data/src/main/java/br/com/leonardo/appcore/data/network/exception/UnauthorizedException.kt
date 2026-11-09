package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.UNAUTHORIZED_EXCEPTION_MESSAGE
import java.io.IOException

class UnauthorizedException(
    message: String = UNAUTHORIZED_EXCEPTION_MESSAGE,
) : IOException(message)
