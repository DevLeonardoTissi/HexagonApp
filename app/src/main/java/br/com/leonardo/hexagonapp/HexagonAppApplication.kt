package br.com.leonardo.hexagonapp

import android.app.Application
import br.com.leonardo.appcore.data.notification.CreateNotificationChannel
import br.com.leonardo.hexagonapp.extensions.startKoinModules
import org.koin.android.ext.android.inject

/**
 * Main [Application] class for HexagonApp.
 * Initializes Koin dependency injection and system notification channels.
 */
class HexagonAppApplication : Application() {
    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects have been created.
     */
    override fun onCreate() {
        super.onCreate()
        startKoinModules()

        val createNotificationChannel: CreateNotificationChannel by inject()
        createNotificationChannel.create()
    }
}
