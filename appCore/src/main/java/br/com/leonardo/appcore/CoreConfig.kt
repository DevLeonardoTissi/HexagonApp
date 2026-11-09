package br.com.leonardo.appcore

import br.com.leonardo.appcore.data.di.DataDiLibrary
import org.koin.core.module.Module

object CoreConfig {
    fun getModules(): Module = DataDiLibrary().getModules()
}
