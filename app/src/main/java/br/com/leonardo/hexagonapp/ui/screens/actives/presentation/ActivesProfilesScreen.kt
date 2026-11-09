package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.screen.HexagonScreen
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentLayout.ActivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentProvider.ActivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.navigation.route.HomeRoute
import org.koin.compose.viewmodel.koinViewModel

class ActivesProfilesScreen :
    HexagonScreen<
        HomeRoute,
        ActivesProfilesState,
        ActivesProfilesUiState,
        ActivesProfilesViewModel,
        ActivesProfilesScreenContentLayout,
        ActivesProfilesScreenContentProvider,
    >() {
    @Composable
    override fun provideViewModel(arguments: HomeRoute?): ActivesProfilesViewModel =
        koinViewModel<ActivesProfilesViewModel>()

    override val provideContentLayout: ActivesProfilesScreenContentLayout =
        ActivesProfilesScreenContentLayout()
    override val provideContentProvider: ActivesProfilesScreenContentProvider =
        ActivesProfilesScreenContentProvider()
}
