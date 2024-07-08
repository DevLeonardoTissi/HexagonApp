package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreen
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenUiState
import br.com.leonardo.hexagonapp.ui.screens.home.HomeScreenViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object HomeRoute

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<HomeRoute>{

        val viewModel: HomeScreenViewModel = koinViewModel()
        val uiState: HomeScreenUiState by viewModel.uiState.collectAsState()

        HomeScreen(uiState = uiState, onClickItem = { id ->
            navController.navigate(FormRoute(id))
        }, onDelete = { profile ->
            viewModel.remove(profile)
        })
    }
}

