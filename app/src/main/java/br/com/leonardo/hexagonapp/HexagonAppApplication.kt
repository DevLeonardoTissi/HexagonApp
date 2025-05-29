package br.com.leonardo.hexagonapp

import android.app.Application
import br.com.leonardo.hexagonapp.utils.extensions.application.startKoinModules

class HexagonAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinModules()
    }
}