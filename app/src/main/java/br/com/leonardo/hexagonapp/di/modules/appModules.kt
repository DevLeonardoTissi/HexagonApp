package br.com.leonardo.hexagonapp.di.modules

import android.app.NotificationManager
import android.content.Context
import br.com.leonardo.hexagonapp.notification.CreateNotificationChannel
import br.com.leonardo.hexagonapp.notification.NotificationUseCase
import br.com.leonardo.hexagonapp.notification.NotificationUseCaseImpl
import br.com.leonardo.hexagonapp.ui.activity.AppViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val notificationModule = module {
    single<NotificationManager> { get<Context>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }

    singleOf(::NotificationUseCaseImpl) { bind <NotificationUseCase>() }
    singleOf(::CreateNotificationChannel) { bind <CreateNotificationChannel>() }

//
//    single<CreateNotificationChannel> {
//        CreateNotificationChannel(
//            get<Context>(),
//            get<NotificationManager>()
//        )
//    }
//    single<NotificationUseCase> {
//        NotificationUseCaseImpl(
//            get<Context>(),
//            get<NotificationManager>()
//        )
//    }
}


val viewModelModule = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::PersonalProfileFormViewModel)
    viewModelOf(::InactiveProfilesViewModel)
    viewModelOf(::AppViewModel)
    viewModelOf(::DevProfileViewModel)

}