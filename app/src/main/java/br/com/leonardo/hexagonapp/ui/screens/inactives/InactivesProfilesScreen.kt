package br.com.leonardo.hexagonapp.ui.screens.inactives

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.inactives.contentLayout.InactivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider.InactivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.navigator.route.InactiveRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.androidx.compose.koinViewModel

class InactivesProfilesScreen : HexagonScreen<InactiveRoute,
        InactivesProfilesState,
        InactivesProfilesUiState,
        InactivesProfilesViewModel,
        InactivesProfilesScreenContentLayout,
        InactivesProfilesScreenContentProvider>() {
    @Composable
    override fun provideViewModel(arguments: InactiveRoute?): InactivesProfilesViewModel {
        return koinViewModel<InactivesProfilesViewModel>()
    }

    override val provideContentLayout: InactivesProfilesScreenContentLayout =
        InactivesProfilesScreenContentLayout()
    override val provideContentProvider: InactivesProfilesScreenContentProvider =
        InactivesProfilesScreenContentProvider()


}