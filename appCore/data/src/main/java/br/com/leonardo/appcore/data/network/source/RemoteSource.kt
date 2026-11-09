package br.com.leonardo.appcore.data.network.source

import br.com.leonardo.appcore.data.network.exception.EmptyResponseException
import retrofit2.HttpException
import retrofit2.Response

/**
 * Remote source
 */
@Suppress("TooGenericExceptionCaught")
interface RemoteSource {
    /**
     * Request not nullable
     * Suspending function — must be called from a coroutine or another suspending function.
     *
     * @param E
     * @param M
     * @param call
     * @receiver
     * @param onSuccess the on success
     * @receiver
     * @param onError the on error
     * @receiver
     * @return the result
     */
    suspend fun <E, M> requestNotNullable(
        call: suspend () -> Response<E>,
        onSuccess: (code: Int, response: E) -> M,
        onError: (code: Int, callThrowable: Throwable) -> Throwable = { _, callThrowable ->
            callThrowable
        },
    ): Result<M> =
        try {
            val response = call()
            if (response.isSuccessful) {
                response.body()?.let { bodyNonNull ->
                    Result.success(
                        value =
                            onSuccess(
                                response.code(),
                                bodyNonNull,
                            ),
                    )
                } ?: Result.failure(exception = EmptyResponseException())
            } else {
                Result.failure(
                    exception =
                        onError(
                            response.code(),
                            HttpException(response),
                        ),
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    /**
     * Request nullable
     * Suspending function — must be called from a coroutine or another suspending function.
     *
     * @param E
     * @param M
     * @param call
     * @receiver
     * @param onSuccess the on success
     * @receiver
     * @param onError the on error
     * @receiver
     * @return the result
     */
    suspend fun <E, M> requestNullable(
        call: suspend () -> Response<E?>,
        onSuccess: (code: Int, response: E?) -> M,
        onError: (code: Int, callThrowable: Throwable) -> Throwable = { _, callThrowable ->
            callThrowable
        },
    ): Result<M> =
        try {
            val response = call()
            if (response.isSuccessful) {
                Result.success(
                    value =
                        onSuccess(
                            response.code(),
                            response.body(),
                        ),
                )
            } else {
                Result.failure(
                    exception =
                        onError(
                            response.code(),
                            HttpException(response),
                        ),
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
}
