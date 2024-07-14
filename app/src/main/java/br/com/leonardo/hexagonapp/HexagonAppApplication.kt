package br.com.leonardo.hexagonapp

import android.app.Application
import br.com.leonardo.hexagonapp.di.modules.viewModelModule
import br.com.leonardo.localData.di.modules.localDataRepositoryModule
import br.com.leonardo.webClient.di.modules.webClientRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HexagonAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HexagonAppApplication)
            modules(
                localDataRepositoryModule,
                viewModelModule,
                webClientRepositoryModule
            )
        }
    }
}