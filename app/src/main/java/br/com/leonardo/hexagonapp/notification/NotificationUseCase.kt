package br.com.leonardo.hexagonapp.notification

import android.app.PendingIntent

interface NotificationUseCase {

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
        contentIntent: PendingIntent? = null
    )

    fun cancel(exclusiveId: Int?)
}