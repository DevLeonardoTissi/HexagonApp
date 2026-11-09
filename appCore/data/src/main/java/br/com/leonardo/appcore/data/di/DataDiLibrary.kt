package br.com.leonardo.appcore.data.di

import br.com.leonardo.appcore.data.network.di.NetworkDI
import br.com.leonardo.appcore.data.notification.di.NotificationDI
import br.com.leonardo.appcore.data.permission.di.PermissionDI
import br.com.leonardo.appcore.data.usecase.di.UseCaseDI
import br.com.leonardo.appcore.di.module.HexagonLibrary
import org.koin.core.module.Module
import org.koin.dsl.module

class DataDiLibrary : HexagonLibrary {
    private val networkModules = NetworkDI()
    private val notificationModules = NotificationDI()
    private val permissionModules = PermissionDI()
    private val useCaseModules = UseCaseDI()

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
