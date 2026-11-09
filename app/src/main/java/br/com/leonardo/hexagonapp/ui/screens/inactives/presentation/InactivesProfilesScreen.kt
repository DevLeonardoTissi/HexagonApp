package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.screen.HexagonScreen
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentLayout.InactivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider.InactivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.navigation.route.InactiveRoute
import org.koin.androidx.compose.koinViewModel

/** Main screen composable for displaying inactive personal profiles. */
class InactivesProfilesScreen :
    HexagonScreen<
        InactiveRoute,
        InactivesProfilesState,
        InactivesProfilesUiState,
        InactivesProfilesViewModel,
        InactivesProfilesScreenContentLayout,
        InactivesProfilesScreenContentProvider,
    >() {
    @Composable
    override fun provideViewModel(arguments: InactiveRoute?): InactivesProfilesViewModel =
        koinViewModel<InactivesProfilesViewModel>()

    override val provideContentLayout: InactivesProfilesScreenContentLayout =
        InactivesProfilesScreenContentLayout()
    override val provideContentProvider: InactivesProfilesScreenContentProvider =
        InactivesProfilesScreenContentProvider()
}
