package br.com.leonardo.hexagonapp

import android.app.Application
import br.com.leonardo.hexagonapp.di.modules.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HexagonAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HexagonAppApplication)
            modules(
                databaseModule
            )
        }
    }
}