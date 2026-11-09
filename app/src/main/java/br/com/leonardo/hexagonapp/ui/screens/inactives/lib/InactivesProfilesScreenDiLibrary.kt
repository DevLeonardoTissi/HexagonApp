package br.com.leonardo.hexagonapp.ui.screens.inactives.lib

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.inactives.lib.presentation.InactivesProfilesPresentationDiLibrary
import org.koin.dsl.module

class InactivesProfilesScreenDiLibrary : HexagonLibrary {
    private val presentationLibrary = InactivesProfilesPresentationDiLibrary()

    override fun getModules() =
        module {
            includes(presentationLibrary.getModules())
        }
}
