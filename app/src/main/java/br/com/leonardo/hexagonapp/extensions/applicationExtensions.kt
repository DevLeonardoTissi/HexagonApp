package br.com.leonardo.hexagonapp.extensions

import android.app.Application
import br.com.leonardo.appcore.data.di.DataDiLibrary
import br.com.leonardo.hexagonapp.di.modules.navigatorModule
import br.com.leonardo.hexagonapp.di.modules.screensModules
import br.com.leonardo.localData.di.modules.localDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

fun getAppModules(): List<Module> =
    listOf(
        localDataModule,
        DataDiLibrary().getModules(),
        navigatorModule,
        screensModules,
    )

fun Application.startKoinModules() {
    startKoin {
        androidContext(this@startKoinModules)
        modules(getAppModules())
    }
}
