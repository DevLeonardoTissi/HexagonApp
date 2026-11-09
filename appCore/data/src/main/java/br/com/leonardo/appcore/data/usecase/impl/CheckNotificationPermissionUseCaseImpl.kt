package br.com.leonardo.appcore.data.usecase.impl

import br.com.leonardo.appcore.domain.permission.AndroidNotificationsPermissionChecker
import br.com.leonardo.appcore.domain.usecase.CheckNotificationPermissionUseCase

class CheckNotificationPermissionUseCaseImpl(
    private val androidPermissionChecker: AndroidNotificationsPermissionChecker,
) : CheckNotificationPermissionUseCase {
    override fun invoke(): Boolean = androidPermissionChecker.shouldAskNotificationPermission()
}
