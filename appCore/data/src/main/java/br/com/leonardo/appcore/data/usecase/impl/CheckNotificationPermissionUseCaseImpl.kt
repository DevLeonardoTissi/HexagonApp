package br.com.leonardo.appcore.data.usecase.impl

import br.com.leonardo.appcore.domain.permission.AndroidNotificationsPermissionChecker
import br.com.leonardo.appcore.domain.usecase.CheckNotificationPermissionUseCase

/**
 * Implementation of [CheckNotificationPermissionUseCase].
 *
 * @property androidPermissionChecker Verifier for Android system notification permissions.
 */
class CheckNotificationPermissionUseCaseImpl(
    private val androidPermissionChecker: AndroidNotificationsPermissionChecker,
) : CheckNotificationPermissionUseCase {
    /**
     * Executes permission check.
     *
     * @return `true` if notification permission is needed; `false` otherwise.
     */
    override fun invoke(): Boolean = androidPermissionChecker.shouldAskNotificationPermission()
}
