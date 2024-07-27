package br.com.leonardo.localData

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

//Para módulos dinamicos
//caso nao queira, nao utilizar classe
class KoinTestRuleTest(private val modules : List<Module>) : TestWatcher(){
    override fun starting(description: Description?) {
        super.starting(description)
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
            modules(modules)
        }
    }
    override fun finished(description: Description) {
        stopKoin()
    }

}