package br.com.leonardo.hexagonapp.ui.screens.devProfile.lib

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.data.DevProfileDataDiLibrary
import br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.domain.DevProfileDomainDiLibrary
import br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.presentation.DevProfilePresentationDiLibrary
import org.koin.dsl.module

class DevProfileScreenDiLibrary : HexagonLibrary {
    private val dataLibrary = DevProfileDataDiLibrary()
    private val domainLibrary = DevProfileDomainDiLibrary()
    private val presentationLibrary = DevProfilePresentationDiLibrary()

    override fun getModules() =
        module {
            includes(dataLibrary.getModules())
            includes(domainLibrary.getModules())
            includes(presentationLibrary.getModules())
        }
}
