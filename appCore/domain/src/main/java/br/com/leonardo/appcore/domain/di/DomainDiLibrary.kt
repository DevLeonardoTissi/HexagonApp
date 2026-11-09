package br.com.leonardo.appcore.domain.di

import br.com.leonardo.appcore.di.module.HexagonLibrary
import org.koin.dsl.module

class DomainDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
        }
}
