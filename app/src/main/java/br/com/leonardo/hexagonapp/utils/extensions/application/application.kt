package br.com.leonardo.hexagonapp.utils.extensions.application

import android.app.Application
import br.com.leonardo.hexagonapp.di.modules.viewModelModule
import br.com.leonardo.localData.di.modules.localDataRepositoryModule
import br.com.leonardo.webClient.di.modules.webClientRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

fun Application.getAppModules(): List<Module> = listOf(
    localDataRepositoryModule,
    viewModelModule,
    webClientRepositoryModule
)

fun Application.startKoinModules() {
    startKoin {
        androidContext(this@startKoinModules)
        modules(getAppModules())
    }
}