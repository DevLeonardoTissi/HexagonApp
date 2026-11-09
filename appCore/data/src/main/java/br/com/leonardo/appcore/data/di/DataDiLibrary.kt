package br.com.leonardo.appcore.data.di

import br.com.leonardo.appcore.data.network.di.NetworkDI
import br.com.leonardo.appcore.data.notification.di.NotificationDI
import br.com.leonardo.appcore.data.permission.di.PermissionDI
import br.com.leonardo.appcore.data.usecase.di.UseCaseDI
import br.com.leonardo.appcore.di.module.HexagonLibrary
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Dependency Injection Library for the Data Layer.
 * Aggregates network, notification, permission, and infrastructure use case Koin modules.
 */
class DataDiLibrary : HexagonLibrary {
    private val networkModules = NetworkDI()
    private val notificationModules = NotificationDI()
    private val permissionModules = PermissionDI()
    private val useCaseModules = UseCaseDI()

    /**
     * Returns the unified Koin module for the data layer.
     *
     * @return [Module] configured with data services and repositories.
     */
    override fun getModules(): Module =
        module {
            includes(
                networkModules.getModules(),
                notificationModules.getModules(),
                permissionModules.getModules(),
                useCaseModules.getModules(),
            )
        }
}
