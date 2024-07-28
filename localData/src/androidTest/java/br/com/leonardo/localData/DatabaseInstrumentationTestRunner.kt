package br.com.leonardo.localData

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
@Suppress("unused")
class DatabaseInstrumentationTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}