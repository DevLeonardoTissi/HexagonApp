package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.screen.HexagonScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.contentProvider.DevProfileScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.navigation.route.DevProfileScreenRoute
import org.koin.compose.viewmodel.koinViewModel

class DevProfileScreen :
    HexagonScreen<
        DevProfileScreenRoute,
        DevProfileState,
        DevProfileUIState,
        DevProfileViewModel,
        DevProfileScreenContentLayout,
        DevProfileScreenContentProvider,
    >() {
    @Composable
    override fun provideViewModel(arguments: DevProfileScreenRoute?): DevProfileViewModel =
        koinViewModel<DevProfileViewModel>()

    override val provideContentLayout: DevProfileScreenContentLayout =
        DevProfileScreenContentLayout()
    override val provideContentProvider: DevProfileScreenContentProvider =
        DevProfileScreenContentProvider()
}
