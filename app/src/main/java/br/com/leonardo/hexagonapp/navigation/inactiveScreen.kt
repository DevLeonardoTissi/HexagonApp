package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveScreen
import org.koin.androidx.compose.koinViewModel

internal const val inactiveRoute = "inactive"

fun NavGraphBuilder.inactiveScreen(navController: NavController) {
    composable(inactiveRoute) {

        val viewModel: InactiveProfilesViewModel = koinViewModel()
        val uiState: InactiveProfilesUiState by viewModel.uiState.collectAsState()

        InactiveScreen(uiState = uiState, onClickItem = { id ->
            navController.navigateToForm(id)
        }, onDelete = { profile ->
            viewModel.remove(profile)
        })
    }
}

fun NavController.navigateToInactive(navOptions: NavOptions? = null) {
    navigate(inactiveRoute, navOptions)
}