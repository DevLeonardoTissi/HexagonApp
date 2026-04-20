package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentProvider.DevProfileScreenContentProvider
import br.com.leonardo.ui.screen.HexagonScreen
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

class DevProfileScreen : HexagonScreen {
    @Serializable
    object DevProfileRoute

    override fun registerScreen(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<DevProfileRoute> {
            Content()
        }
    }

    @Composable
    override fun Content(arguments: Any?) {
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