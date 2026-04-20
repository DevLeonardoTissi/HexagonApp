package br.com.leonardo.hexagonapp.di.modules

import android.app.NotificationManager
import android.content.Context
import br.com.leonardo.hexagonapp.navigation.HexagonNavigatorImpl
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.notification.CreateNotificationChannel
import br.com.leonardo.hexagonapp.usecase.NotificationUseCase
import br.com.leonardo.hexagonapp.usecase.impl.NotificationUseCaseImpl
import br.com.leonardo.hexagonapp.ui.activity.AppViewModel
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesViewModel
import br.com.leonardo.hexagonapp.usecase.BatteryMonitorUseCase
import br.com.leonardo.hexagonapp.usecase.BatteryMonitorUseCaseImpl
import br.com.leonardo.hexagonapp.usecase.CheckNotificationPermissionUseCase
import br.com.leonardo.hexagonapp.usecase.impl.CheckNotificationPermissionUseCaseImpl
import br.com.leonardo.hexagonapp.utils.AndroidPermissionChecker
import br.com.leonardo.hexagonapp.utils.AndroidPermissionCheckerImpl
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val notificationModule = module {
    single<NotificationManager> { get<Context>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }

    singleOf(::CreateNotificationChannel) { bind<CreateNotificationChannel>() }

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

val utilsModule = module {
    singleOf(::AndroidPermissionCheckerImpl) { bind<AndroidPermissionChecker>() }

}

val appUseCaseModules = module {
    singleOf(::NotificationUseCaseImpl) { bind<NotificationUseCase>() }
    singleOf(::CheckNotificationPermissionUseCaseImpl) { bind<CheckNotificationPermissionUseCase>() }
    singleOf(::BatteryMonitorUseCaseImpl) { bind<BatteryMonitorUseCase>() }
}


val viewModelModule = module {
    viewModelOf(::ActivesProfilesViewModel)
    viewModelOf(::PersonalProfileFormViewModel)
    viewModelOf(::InactivesProfilesViewModel)
    viewModelOf(::AppViewModel)
    viewModelOf(::DevProfileViewModel)

}

val screensModule = module {
    registerScreen { DevProfileScreen() }
    registerScreen { ActivesProfilesScreen() }
    registerScreen { InactivesProfilesScreen() }
    registerScreen { PersonalProfileFormScreen() }

}

val navigatorModule = module {
    single<HexagonNavigator> { HexagonNavigatorImpl() }
}


inline fun <reified T : HexagonScreen> Module.registerScreen(crossinline instance: () -> T) {
    single(named(T::class.java.name)) { instance() } bind HexagonScreen::class
}