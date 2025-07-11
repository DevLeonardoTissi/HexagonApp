package br.com.leonardo.hexagonapp.usecase.impl

import br.com.leonardo.hexagonapp.usecase.CheckNotificationPermissionUseCase
import br.com.leonardo.hexagonapp.utils.AndroidPermissionChecker

class CheckNotificationPermissionUseCaseImpl(private val androidPermissionChecker: AndroidPermissionChecker) :
    CheckNotificationPermissionUseCase {
    override fun invoke(): Boolean {
        return androidPermissionChecker.shouldAskNotificationPermission()
    }
}