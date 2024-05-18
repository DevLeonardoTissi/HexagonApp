package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreen
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenUiState
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

internal const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(homeRoute) {

        val viewModel: HomeScreenViewModel = koinViewModel()
        val uiState: HomeScreenUiState by viewModel.uiState.collectAsState()

        HomeScreen(uiState = uiState, onClickItem = { id ->
            navController.navigateToEdit(id)
        }, onDelete = { viewModel.remove(it) })
    }
}

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(homeRoute, navOptions)
}