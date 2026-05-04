package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentProvider.DevProfileScreenContentProvider
import br.com.leonardo.hexagonapp.ui.screens.devProfile.navigator.route.DevProfileScreenRoute
import br.com.leonardo.ui.screen.HexagonScreen
import org.koin.compose.viewmodel.koinViewModel

class DevProfileScreen : HexagonScreen<DevProfileScreenRoute> {

    @Composable
    override fun Content(arguments: DevProfileScreenRoute?) {
            val viewModel: DevProfileViewModel = koinViewModel()
            val state by viewModel.data.state.collectAsStateWithLifecycle()
            val uiState by viewModel.uiData.uiState.collectAsStateWithLifecycle()

            val contentLayout = DevProfileScreenContentLayout()
            val contentProvider = DevProfileScreenContentProvider()

            contentLayout.Layout(
                state = state,
                uiState = uiState,
                contentProvider = contentProvider,
                modifier = Modifier.fillMaxSize(),
                onActions = { action ->
                    (action as? DevProfileActions)?.let { viewModel.executeAction(it) }
                }
            )
    }
}