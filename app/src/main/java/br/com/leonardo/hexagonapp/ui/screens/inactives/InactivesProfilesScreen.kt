package br.com.leonardo.hexagonapp.ui.screens.inactives

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.hexagonapp.ui.screens.inactives.contentLayout.InactivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider.InactivesProfilesScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.navigator.route.InactiveRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.androidx.compose.koinViewModel

class InactivesProfilesScreen : HexagonScreen<InactiveRoute> {

    @Composable
    override fun Content(arguments:InactiveRoute?) {
        val viewModel: InactivesProfilesViewModel = koinViewModel()
        val state: InactivesProfilesState by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: InactivesProfilesUiState by viewModel.uiData.uiState.collectAsStateWithLifecycle()

        val contentLayout = InactivesProfilesScreenContentLayout()
        val contentProvider = InactivesProfilesScreenContentProvider()

        contentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = contentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { inactivesActions ->
                (inactivesActions as? InactivesProfilesActions)?.let {
                    viewModel.executeAction(it)
                }
            }
        )
    }

}