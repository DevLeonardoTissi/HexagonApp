package br.com.leonardo.appcore.data.permission.impl

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import br.com.leonardo.appcore.domain.permission.AndroidNotificationsPermissionChecker

/**
 * Android implementation for checking notification runtime permissions on SDK 33+ (Tiramisu).
 *
 * @property context Application context.
 */
class AndroidNotificationsPermissionCheckerImpl(
    private val context: Context,
) : AndroidNotificationsPermissionChecker {
    /**
     * Checks if notification permission should be requested from the user.
     *
     * @return `true` if permission is required and not yet granted; `false` otherwise.
     */
    override fun shouldAskNotificationPermission(): Boolean =
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS,
            ) != PackageManager.PERMISSION_GRANTED
}
