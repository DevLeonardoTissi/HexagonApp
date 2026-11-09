package br.com.leonardo.hexagonapp.extensions

import android.app.Application
import br.com.leonardo.appcore.CoreConfig
import br.com.leonardo.hexagonapp.di.modules.navigatorModule
import br.com.leonardo.hexagonapp.di.modules.screensModules
import br.com.leonardo.localData.di.modules.localDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

/**
 * Returns the list of all Koin modules required for the application.
 *
 * @return [List] of [Module] instances.
 */
fun getAppModules(): List<Module> =
    listOf(
        localDataModule,
        CoreConfig.getModules(),
        navigatorModule,
        screensModules,
    )

/**
 * Starts Koin dependency injection container for the [Application].
 */
fun Application.startKoinModules() {
    startKoin {
        androidContext(this@startKoinModules)
        modules(getAppModules())
    }
}
