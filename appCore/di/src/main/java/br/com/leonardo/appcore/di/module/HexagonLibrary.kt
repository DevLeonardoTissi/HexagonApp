package br.com.leonardo.appcore.di.module

import org.koin.core.module.Module

/**
 * Interface representing a modular Koin dependency injection library container.
 */
interface HexagonLibrary {
    /**
     * Returns the Koin [Module] defined by this library.
     *
     * @return [Module] containing dependency definitions.
     */
    fun getModules(): Module
}
