package br.com.leonardo.appcore.data.permission.di

import br.com.leonardo.appcore.data.permission.impl.AndroidNotificationsPermissionCheckerImpl
import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.domain.permission.AndroidNotificationsPermissionChecker
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Dependency Injection Module for Android permission checkers.
 */
class PermissionDI : HexagonLibrary {
    /**
     * Returns the Koin module registering notification permission checkers.
     *
     * @return [Module] configured with permission checkers.
     */
    override fun getModules(): Module =
        module {
            singleOf(::AndroidNotificationsPermissionCheckerImpl) { bind<AndroidNotificationsPermissionChecker>() }
        }
}
