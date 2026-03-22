package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object DevProfileRoute

fun NavGraphBuilder.devProfileScreen() {
    composable<DevProfileRoute> {
        val viewModel: DevProfileViewModel = koinViewModel()
        val state: DevProfileState by viewModel.data.state.collectAsState()
        val uiState: DevProfileUIState by viewModel.uiData.uiState.collectAsState()
        DevProfileScreen(
            state = state,
            uiState = uiState,
            onAction = { devProfileScreenAction -> viewModel.executeAction(devProfileScreenAction) })
    }
}
