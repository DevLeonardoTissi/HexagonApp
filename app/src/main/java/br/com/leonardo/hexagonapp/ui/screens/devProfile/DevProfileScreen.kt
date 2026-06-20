package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentProvider.DevProfileScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator.route.DevProfileScreenRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.compose.viewmodel.koinViewModel

class DevProfileScreen : HexagonScreen<
        DevProfileScreenRoute,
        DevProfileState,
        DevProfileUIState,
        DevProfileViewModel,
        DevProfileScreenContentLayout,
        DevProfileScreenContentProvider>() {


    @Composable
    override fun provideViewModel(arguments: DevProfileScreenRoute?): DevProfileViewModel {
        return koinViewModel<DevProfileViewModel>()
    }

    override val provideContentLayout: DevProfileScreenContentLayout =
        DevProfileScreenContentLayout()
    override val provideContentProvider: DevProfileScreenContentProvider =
        DevProfileScreenContentProvider()


}