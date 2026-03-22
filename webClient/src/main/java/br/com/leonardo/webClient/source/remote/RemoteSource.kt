package br.com.leonardo.webClient.source.remote

import br.com.leonardo.webClient.exception.EmptyResponseException

interface RemoteSource {

    suspend fun <RE> requestNotNullable(
        block: suspend () -> RE?,
    ): Result<RE> {
        return try {
            val response = block()
            if (response != null) {
                Result.success(value = response)
            } else {
                Result.failure(exception = EmptyResponseException())
            }
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }

}