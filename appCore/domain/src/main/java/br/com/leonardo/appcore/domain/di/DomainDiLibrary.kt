package br.com.leonardo.appcore.domain.di

import br.com.leonardo.appcore.di.module.HexagonLibrary
import org.koin.dsl.module

/**
 * Dependency Injection Library for the base Domain layer.
 */
class DomainDiLibrary : HexagonLibrary {
    /**
     * Returns the Koin module for domain definitions.
     *
     * @return [Module] containing domain definitions.
     */
    override fun getModules() =
        module {
        }
}
