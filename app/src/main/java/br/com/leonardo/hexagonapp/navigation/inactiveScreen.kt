package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactive.InactiveScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object InactiveRoute

fun NavGraphBuilder.inactiveScreen(navController: NavController) {
    composable<InactiveRoute>{

        val viewModel: InactiveProfilesViewModel = koinViewModel()
        val uiState: InactiveProfilesUiState by viewModel.uiState.collectAsState()

        InactiveScreen(uiState = uiState, onClickItem = { id ->
            navController.navigate(FormRoute(id))
        }, onDelete = { profile ->
            viewModel.remove(profile)
        })
    }
}