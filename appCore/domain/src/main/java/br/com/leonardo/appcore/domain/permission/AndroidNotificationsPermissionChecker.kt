package br.com.leonardo.appcore.domain.permission

/**
 * Interface for checking whether notification runtime permissions should be requested.
 */
interface AndroidNotificationsPermissionChecker {
    /**
     * Determines if notification permission needs to be requested from the user.
     *
     * @return `true` if permission should be requested, `false` otherwise.
     */
    fun shouldAskNotificationPermission(): Boolean
}
