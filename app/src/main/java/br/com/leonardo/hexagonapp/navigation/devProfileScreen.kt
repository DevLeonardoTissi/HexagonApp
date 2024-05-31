package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileScreen
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUiState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import org.koin.androidx.compose.koinViewModel

internal const val devProfileRoute = "devProfileRoute"

fun NavGraphBuilder.devProfileScreen(navController: NavController) {
    composable(devProfileRoute) {

        val viewModel: DevProfileViewModel = koinViewModel()
        val uiState: DevProfileUiState by viewModel.uiState.collectAsState()

        DevProfileScreen(uiState)
    }
}

fun NavController.navigateToDevProfile() {
    navigate(devProfileRoute)
}