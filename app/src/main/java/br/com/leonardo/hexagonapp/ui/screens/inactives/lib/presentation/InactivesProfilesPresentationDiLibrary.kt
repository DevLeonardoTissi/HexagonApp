package br.com.leonardo.hexagonapp.ui.screens.inactives.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.navigation.InactivesProfilesScreenNavigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class InactivesProfilesPresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            inactivesProfilesScreen()
        }

    fun Module.inactivesProfilesScreen() {
        registerScreenNavigation { InactivesProfilesScreenNavigator() }
        viewModelOf(::InactivesProfilesViewModel)
    }
}
