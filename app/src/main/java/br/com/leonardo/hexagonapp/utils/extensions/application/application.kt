package br.com.leonardo.hexagonapp.utils.extensions.application

import android.app.Application
import br.com.leonardo.hexagonapp.di.modules.appUseCaseModules
import br.com.leonardo.hexagonapp.di.modules.notificationModule
import br.com.leonardo.hexagonapp.di.modules.utilsModule
import br.com.leonardo.hexagonapp.di.modules.viewModelModule
import br.com.leonardo.localData.di.modules.localDataModule
import br.com.leonardo.webClient.di.modules.webClientModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

fun getAppModules(): List<Module> = listOf(
    localDataModule,
    viewModelModule,
    webClientModule,
    notificationModule,
    utilsModule,
    appUseCaseModules
)

fun Application.startKoinModules() {
    startKoin {
        androidContext(this@startKoinModules)
        modules(getAppModules())
    }
}