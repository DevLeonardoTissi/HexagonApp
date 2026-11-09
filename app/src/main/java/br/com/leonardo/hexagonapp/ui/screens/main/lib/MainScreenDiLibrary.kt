package br.com.leonardo.hexagonapp.ui.screens.main.lib

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.hexagonapp.ui.screens.main.lib.presentation.MainPresentationDiLibrary
import org.koin.dsl.module

class MainScreenDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            includes(MainPresentationDiLibrary().getModules())
        }
}
