package br.com.leonardo.appcore.data.network.exception

import br.com.leonardo.appcore.data.network.utils.FORBIDDEN_EXCEPTION_MESSAGE
import java.io.IOException

class ForbiddenException(
    message: String = FORBIDDEN_EXCEPTION_MESSAGE,
) : IOException(message)
