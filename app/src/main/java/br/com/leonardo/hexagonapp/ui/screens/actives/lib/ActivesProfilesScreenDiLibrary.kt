package br.com.leonardo.hexagonapp.ui.screens.actives.lib

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.actives.lib.presentation.ActivesProfilesPresentationDiLibrary
import org.koin.dsl.module

class ActivesProfilesScreenDiLibrary : HexagonLibrary {
    private val presentationLibrary = ActivesProfilesPresentationDiLibrary()

    override fun getModules() =
        module {
            includes(presentationLibrary.getModules())
        }
}
