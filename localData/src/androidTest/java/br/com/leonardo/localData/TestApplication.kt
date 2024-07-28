package br.com.leonardo.localData

import android.app.Application

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //To not use dynamic modules
//        startKoin {
//            modules(localDataRepositoryModuleTest)
//        }
    }
}