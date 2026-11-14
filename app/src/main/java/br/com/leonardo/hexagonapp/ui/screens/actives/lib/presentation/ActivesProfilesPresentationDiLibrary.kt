package br.com.leonardo.hexagonapp.ui.screens.actives.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.di.contentLayoutOf
import br.com.leonardo.appcore.presentation.di.contentProviderOf
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentLayout.ActivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentProvider.ActivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.ActivesProfilesScreenNavigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class ActivesProfilesPresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            activesProfilesScreen()
            activesProfilesScreenNavigator()
        }

    fun Module.activesProfilesScreen() {
        scope<ActivesProfilesScreen> {
            contentLayoutOf<
                ActivesProfilesState,
                ActivesProfilesUiState,
                ActivesProfilesScreenContentLayout,
            >()
            contentProviderOf<
                ActivesProfilesState,
                ActivesProfilesUiState,
                ActivesProfilesScreenContentProvider,
            >()
            viewModelOf(::ActivesProfilesViewModel)
        }
    }

    fun Module.activesProfilesScreenNavigator() {
        registerScreenNavigation { ActivesProfilesScreenNavigator() }
    }
}
