package br.com.leonardo.hexagonapp.ui.screens.actives

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.actives.contentLayout.ActivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider.ActivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.navigator.route.HomeRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.compose.viewmodel.koinViewModel

class ActivesProfilesScreen : HexagonScreen<
        HomeRoute,
        ActivesProfilesState,
        ActivesProfilesUiState,
        ActivesProfilesViewModel,
        ActivesProfilesScreenContentLayout,
        ActivesProfilesScreenContentProvider
        >() {


    @Composable
    override fun provideViewModel(
        arguments: HomeRoute?
    ): ActivesProfilesViewModel {
        return koinViewModel<ActivesProfilesViewModel>()
    }

    override val provideContentLayout: ActivesProfilesScreenContentLayout =
        ActivesProfilesScreenContentLayout()
    override val provideContentProvider: ActivesProfilesScreenContentProvider =
        ActivesProfilesScreenContentProvider()
}