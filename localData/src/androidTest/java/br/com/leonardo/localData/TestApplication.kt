package br.com.leonardo.localData

import android.app.Application
import org.koin.core.context.startKoin

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Para não utilizar módulos dinamicos
//        startKoin {
//            modules(localDataRepositoryModuleTest)
//        }
    }
}