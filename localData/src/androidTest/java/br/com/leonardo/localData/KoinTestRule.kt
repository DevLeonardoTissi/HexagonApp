package br.com.leonardo.localData

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

//To not use dynamic modules
//If you don't want to, don't use class
class KoinTestRule(private val modules: List<Module>) : TestWatcher() {
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
