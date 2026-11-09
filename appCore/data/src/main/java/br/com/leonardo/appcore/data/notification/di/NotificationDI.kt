package br.com.leonardo.appcore.data.notification.di

import android.app.NotificationManager
import android.content.Context
import br.com.leonardo.appcore.data.notification.CreateNotificationChannel
import br.com.leonardo.appcore.di.module.HexagonLibrary
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class NotificationDI : HexagonLibrary {
    override fun getModules(): Module =
        module {
            single<NotificationManager> {
                get<Context>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            singleOf(::CreateNotificationChannel) { bind<CreateNotificationChannel>() }
        }
}
