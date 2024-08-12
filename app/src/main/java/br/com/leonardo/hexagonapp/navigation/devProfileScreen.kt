package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUiState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object DevProfileRoute

fun NavGraphBuilder.devProfileScreen() {
    composable<DevProfileRoute> {
        val viewModel: DevProfileViewModel = koinViewModel()
        val uiState: DevProfileUiState by viewModel.uiState.collectAsState()
        DevProfileScreen(uiState)
    }
}
