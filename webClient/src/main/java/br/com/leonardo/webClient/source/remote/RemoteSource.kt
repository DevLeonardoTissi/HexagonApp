package br.com.leonardo.webClient.source.remote

import br.com.leonardo.webClient.exception.EmptyResponseException
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import retrofit2.Response

interface RemoteSource : KoinComponent {

    suspend fun <E, M> requestNotNullable(
        call: suspend () -> Response<E>,
        onSuccess: (code: Int, response: E) -> M,
        onError: (code: Int, callThrowable: Throwable) -> Throwable = { _, callThrowable ->
            callThrowable
        }
    ): Result<M> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let { bodyNonNull ->
                    Result.success(
                        value = onSuccess(
                            response.code(),
                            bodyNonNull
                        )
                    )
                } ?: Result.failure(exception = EmptyResponseException())
            } else {
                Result.failure(
                    exception = onError(
                        response.code(),
                        HttpException(response)
                    )
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}