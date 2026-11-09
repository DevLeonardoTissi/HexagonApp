package br.com.leonardo.appcore.data.usecase.di

import br.com.leonardo.appcore.data.usecase.impl.BatteryMonitorUseCaseImpl
import br.com.leonardo.appcore.data.usecase.impl.CheckNotificationPermissionUseCaseImpl
import br.com.leonardo.appcore.data.usecase.impl.NotificationUseCaseImpl
import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.domain.usecase.BatteryMonitorUseCase
import br.com.leonardo.appcore.domain.usecase.CheckNotificationPermissionUseCase
import br.com.leonardo.appcore.domain.usecase.NotificationUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Dependency Injection Module for global appCore use cases.
 */
class UseCaseDI : HexagonLibrary {
    /**
     * Returns the Koin module registering appCore use case implementations.
     *
     * @return [Module] binding use cases to domain interfaces.
     */
    override fun getModules(): Module =
        module {
            singleOf(::NotificationUseCaseImpl) { bind<NotificationUseCase>() }
            singleOf(::CheckNotificationPermissionUseCaseImpl) { bind<CheckNotificationPermissionUseCase>() }
            singleOf(::BatteryMonitorUseCaseImpl) { bind<BatteryMonitorUseCase>() }
        }
}
