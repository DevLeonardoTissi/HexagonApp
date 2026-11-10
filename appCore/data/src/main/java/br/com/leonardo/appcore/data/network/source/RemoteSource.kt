package br.com.leonardo.appcore.data.network.source

import br.com.leonardo.appcore.data.network.exception.EmptyResponseException
import retrofit2.HttpException
import retrofit2.Response

/**
 * Interface providing helper functions for executing safe network requests
 * with automatic response handling, body nullability checks, and exception mapping.
 */
@Suppress("TooGenericExceptionCaught")
interface RemoteSource {
    /**
     * Executes a suspending network request expecting a non-nullable response body.
     *
     * @param E The network response entity type.
     * @param M The mapped domain model type.
     * @param call Suspending lambda executing the Retrofit service call.
     * @param onSuccess Callback invoked upon successful response with status code and body.
     * @param onError Optional callback invoked upon failure to map or return exceptions.
     * @return A [Result] containing the mapped model [M] or failure exception.
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
     * Executes a suspending network request allowing nullable response bodies.
     *
     * @param E The network response entity type (nullable).
     * @param M The mapped domain model type.
     * @param call Suspending lambda executing the Retrofit service call.
     * @param onSuccess Callback invoked upon successful response with status code and nullable body.
     * @param onError Optional callback invoked upon failure to map or return exceptions.
     * @return A [Result] containing the mapped model [M] or failure exception.
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
