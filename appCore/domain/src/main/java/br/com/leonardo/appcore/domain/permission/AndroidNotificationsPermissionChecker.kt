package br.com.leonardo.appcore.domain.permission

interface AndroidNotificationsPermissionChecker {
    fun shouldAskNotificationPermission(): Boolean
}
