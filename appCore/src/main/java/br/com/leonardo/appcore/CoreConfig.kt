package br.com.leonardo.appcore

import br.com.leonardo.appcore.data.di.DataDiLibrary
import org.koin.core.module.Module

/**
 * Central configuration object for the core module.
 * Provides unified access to Koin infrastructure and data modules.
 */
object CoreConfig {
    /**
     * Returns the aggregated Koin modules for the application core.
     *
     * @return [Module] containing the core dependency injection definitions.
     */
    fun getModules(): Module = DataDiLibrary().getModules()
}
