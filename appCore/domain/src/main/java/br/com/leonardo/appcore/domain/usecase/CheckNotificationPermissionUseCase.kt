package br.com.leonardo.appcore.domain.usecase

/**
 * Use case interface for checking notification permission requirements.
 */
interface CheckNotificationPermissionUseCase {
    /**
     * Checks whether notification permissions need to be requested.
     *
     * @return `true` if permission is required, `false` otherwise.
     */
    operator fun invoke(): Boolean
}
