package br.com.leonardo.appcore.domain.usecase

import android.app.PendingIntent

/**
 * Use case interface for displaying, updating, and cancelling system notifications.
 */
interface NotificationUseCase {
    /**
     * Displays or updates a system notification with optional image, progress, actions, and intents.
     *
     * @param titleStringId String resource ID for the notification title.
     * @param descriptionStringId String resource ID for the notification content description/text.
     * @param img Optional URL or path for a big picture image.
     * @param iconId Drawable resource ID for the notification small icon.
     * @param isOnGoing Whether the notification is ongoing.
     * @param isAutoCancel Whether the notification auto-cancels on tap.
     * @param progress Optional progress value (0 to 100).
     * @param exclusiveId Optional unique notification ID.
     * @param actionIcon Optional icon for the first notification action button.
     * @param actionTitle Optional title for the first notification action button.
     * @param actionIntent Optional [PendingIntent] for the first action.
     * @param secondActionIcon Optional icon for the second notification action button.
     * @param secondActionTitle Optional title for the second notification action button.
     * @param secondActionIntent Optional [PendingIntent] for the second action.
     * @param contentIntent Optional [PendingIntent] fired when notification content is tapped.
     */
    fun show(
        titleStringId: Int,
        descriptionStringId: Int,
        img: String? = null,
        iconId: Int,
        isOnGoing: Boolean? = false,
        isAutoCancel: Boolean? = true,
        progress: Int? = null,
        exclusiveId: Int? = null,
        actionIcon: Int? = null,
        actionTitle: String? = null,
        actionIntent: PendingIntent? = null,
        secondActionIcon: Int? = null,
        secondActionTitle: String? = null,
        secondActionIntent: PendingIntent? = null,
        contentIntent: PendingIntent? = null,
    )

    /**
     * Cancels a specific notification.
     *
     * @param exclusiveId Optional ID of the notification to cancel.
     */
    fun cancel(exclusiveId: Int? = null)

    /**
     * Cancels all notifications posted by this application.
     */
    fun cancelAll()
}
