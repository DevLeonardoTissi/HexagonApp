package br.com.leonardo.hexagonapp.ui.screens.actives.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.ActivesProfilesScreenNavigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class ActivesProfilesPresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            activesProfilesScreen()
        }

    fun Module.activesProfilesScreen() {
        registerScreenNavigation { ActivesProfilesScreenNavigator() }
        viewModelOf(::ActivesProfilesViewModel)
    }
}
