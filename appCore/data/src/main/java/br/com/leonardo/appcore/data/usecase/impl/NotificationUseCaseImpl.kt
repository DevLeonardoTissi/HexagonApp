package br.com.leonardo.appcore.data.usecase.impl

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.Bitmap
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.VISIBILITY_PRIVATE
import androidx.core.content.ContextCompat
import br.com.leonardo.appcore.data.R
import br.com.leonardo.appcore.data.notification.CreateNotificationChannel.Companion.NOTIFICATIONS_CHANNEL_IDENTIFIER
import br.com.leonardo.appcore.domain.usecase.NotificationUseCase
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.toBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Implementation of [NotificationUseCase] for building and dispatching system notifications.
 *
 * @property context Application context.
 * @property notificationManager Android [NotificationManager] system service.
 */
class NotificationUseCaseImpl(
    private val context: Context,
    private val notificationManager: NotificationManager,
) : NotificationUseCase {
    companion object {
        /**
         * Auto-incrementing notification ID counter.
         */
        var id = 1
            private set
    }

    /**
     * Builds and presents a system notification asynchronously.
     */
    override fun show(
        titleStringId: Int,
        descriptionStringId: Int,
        img: String?,
        iconId: Int,
        isOnGoing: Boolean?,
        isAutoCancel: Boolean?,
        progress: Int?,
        exclusiveId: Int?,
        actionIcon: Int?,
        actionTitle: String?,
        actionIntent: PendingIntent?,
        secondActionIcon: Int?,
        secondActionTitle: String?,
        secondActionIntent: PendingIntent?,
        contentIntent: PendingIntent?,
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val image = trySearchImg(img)
            val style = createStyle(image, context.getString(descriptionStringId))
            val notification =
                createNotification(
                    context.getString(titleStringId),
                    context.getString(descriptionStringId),
                    style,
                    iconId,
                    isOnGoing ?: false,
                    isAutoCancel ?: true,
                    progress,
                    actionIcon,
                    actionTitle,
                    actionIntent,
                    secondActionIcon,
                    secondActionTitle,
                    secondActionIntent,
                    contentIntent,
                )

            notificationManager.notify(exclusiveId ?: id, notification)
            exclusiveId ?: id++
        }
    }

    /**
     * Cancels a specific notification by ID.
     *
     * @param exclusiveId Optional specific ID to cancel.
     */
    override fun cancel(exclusiveId: Int?) {
        notificationManager.cancel(exclusiveId ?: id)
    }

    private suspend fun trySearchImg(img: String?): Bitmap? {
        val request =
            ImageRequest
                .Builder(context)
                .data(img)
                .build()
        return context.imageLoader
            .execute(request)
            .image
            ?.toBitmap()
    }

    /**
     * Cancels all currently displayed notifications for this app.
     */
    override fun cancelAll() {
        notificationManager.cancelAll()
    }

    private fun createNotification(
        title: String,
        description: String,
        style: NotificationCompat.Style,
        iconId: Int,
        isOnGoing: Boolean = false,
        isAutoCancel: Boolean = true,
        progress: Int? = null,
        actionIcon: Int? = null,
        actionTitle: String? = null,
        actionIntent: PendingIntent? = null,
        secondActionIcon: Int? = null,
        secondActionTitle: String? = null,
        secondActionIntent: PendingIntent? = null,
        contentIntent: PendingIntent? = null,
    ): Notification {
        val builder =
            NotificationCompat
                .Builder(context, NOTIFICATIONS_CHANNEL_IDENTIFIER)
                .setContentTitle(title)
                .setContentText(description)
                .setSmallIcon(iconId)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(isAutoCancel)
                .setStyle(style)
                .setVisibility(VISIBILITY_PRIVATE)
                .setColor(ContextCompat.getColor(context, R.color.notificationIconColor))
                .setOngoing(isOnGoing)
                .setOnlyAlertOnce(true)
                .setContentIntent(contentIntent)

        progress?.let { progressNonNull ->
            builder.setProgress(100, progressNonNull, false)
        }

        addActionIfNotNull(builder, actionIcon, actionTitle, actionIntent)
        addActionIfNotNull(builder, secondActionIcon, secondActionTitle, secondActionIntent)

        return builder.build()
    }

    private fun createStyle(
        img: Bitmap?,
        description: String,
    ): NotificationCompat.Style =
        img?.let {
            NotificationCompat.BigPictureStyle().bigPicture(it)
        } ?: NotificationCompat.BigTextStyle().bigText(description)

    private fun addActionIfNotNull(
        builder: NotificationCompat.Builder,
        icon: Int?,
        title: String?,
        intent: PendingIntent?,
    ) {
        if (icon != null && title != null && intent != null) {
            builder.addAction(icon, title, intent)
        }
    }
}
