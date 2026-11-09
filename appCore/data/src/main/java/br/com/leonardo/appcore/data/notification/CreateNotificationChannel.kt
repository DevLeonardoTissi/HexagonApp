package br.com.leonardo.appcore.data.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.net.Uri
import androidx.core.net.toUri
import br.com.leonardo.appcore.data.R

class CreateNotificationChannel(
    private val context: Context,
    private val manager: NotificationManager,
) {
    fun create() {
        val name = context.getString(R.string.channel_name)
        val description = context.getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val channel =
            NotificationChannel(NOTIFICATIONS_CHANNEL_IDENTIFIER, name, importance)
                .apply {
                    setDescription(description)
                    setSound(getCustomNotificationSoundUri(), getCustomNotificationSoundAttributes())
                }

        manager.createNotificationChannel(channel)
    }

    private fun getCustomNotificationSoundUri(): Uri =
        "android.resource://${context.packageName}/raw/notification_custom_sound".toUri()

    private fun getCustomNotificationSoundAttributes(): AudioAttributes =
        AudioAttributes
            .Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()

    companion object {
        const val NOTIFICATIONS_CHANNEL_IDENTIFIER = "a11d082b-8a27-4b8f-a5bc-5a17aced5cfc"
    }
}
