package br.com.leonardo.hexagonapp.ui.screens.actives

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.hexagonapp.ui.screens.actives.contentLayout.ActivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider.ActivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.navigator.route.HomeRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.androidx.compose.koinViewModel

class ActivesProfilesScreen: HexagonScreen<HomeRoute> {

    @Composable
    override fun Content(arguments: HomeRoute?) {
        val viewModel: ActivesProfilesViewModel = koinViewModel()
        val state: ActivesProfilesState by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: ActivesProfilesUiState by viewModel.uiData.uiState.collectAsStateWithLifecycle()

        val contentLayout = ActivesProfilesScreenContentLayout()
        val contentProvider = ActivesProfilesScreenContentProvider()

        contentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = contentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { activesActions ->
                (activesActions as? ActivesProfilesActions)?.let {
                    viewModel.executeAction(it)
                }
            }
        )
    }

}