package br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.navigation.DevProfileScreenNavigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class DevProfilePresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            devProfileScreen()
        }

    fun Module.devProfileScreen() {
        registerScreenNavigation { DevProfileScreenNavigator() }
        viewModelOf(::DevProfileViewModel)
    }
}
