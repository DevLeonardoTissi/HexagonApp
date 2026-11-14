package br.com.leonardo.hexagonapp.ui.screens.inactives.lib.presentation

import br.com.leonardo.appcore.di.module.HexagonLibrary
import br.com.leonardo.appcore.presentation.di.contentLayoutOf
import br.com.leonardo.appcore.presentation.di.contentProviderOf
import br.com.leonardo.appcore.presentation.navigator.registerScreenNavigation
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentLayout.InactivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider.InactivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.navigation.InactivesProfilesScreenNavigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class InactivesProfilesPresentationDiLibrary : HexagonLibrary {
    override fun getModules() =
        module {
            inactivesProfilesScreen()
            inactivesProfilesScreenNavigator()
        }

    fun Module.inactivesProfilesScreen() {
        scope<InactivesProfilesScreen> {
            contentLayoutOf<
                InactivesProfilesState,
                InactivesProfilesUiState,
                InactivesProfilesScreenContentLayout,
            >()
            contentProviderOf<
                InactivesProfilesState,
                InactivesProfilesUiState,
                InactivesProfilesScreenContentProvider,
            >()
            viewModelOf(::InactivesProfilesViewModel)
        }
    }

    fun Module.inactivesProfilesScreenNavigator() {
        registerScreenNavigation { InactivesProfilesScreenNavigator() }
    }
}
