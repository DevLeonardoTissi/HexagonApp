package br.com.leonardo.hexagonapp

import android.app.Application
import br.com.leonardo.hexagonapp.notification.CreateNotificationChannel
import br.com.leonardo.hexagonapp.utils.extensions.application.startKoinModules
import org.koin.android.ext.android.inject

class HexagonAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinModules()

        val createNotificationChannel: CreateNotificationChannel by inject()
        createNotificationChannel.create()
    }

}