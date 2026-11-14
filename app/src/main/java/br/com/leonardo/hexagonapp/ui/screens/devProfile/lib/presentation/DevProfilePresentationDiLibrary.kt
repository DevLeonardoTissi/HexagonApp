package br.com.leonardo.hexagonapp.ui.screens.devProfile.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.di.contentLayoutOf
import br.com.leonardo.appcore.presentation.di.contentProviderOf
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.contentProvider.DevProfileScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.navigation.DevProfileScreenNavigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class DevProfilePresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            devProfileScreen()
            devProfileScreenNavigator()
        }

    fun Module.devProfileScreen() {
        scope<DevProfileScreen> {
            contentLayoutOf<
                DevProfileState,
                DevProfileUIState,
                DevProfileScreenContentLayout,
            >()
            contentProviderOf<
                DevProfileState,
                DevProfileUIState,
                DevProfileScreenContentProvider,
            >()
            viewModelOf(::DevProfileViewModel)
        }
    }

    fun Module.devProfileScreenNavigator() {
        registerScreenNavigation { DevProfileScreenNavigator() }
    }
}
