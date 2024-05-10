package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUiState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import org.koin.androidx.compose.koinViewModel

internal const  val formRoute = "form"
private const val profileIdArgument = "id"

fun NavGraphBuilder.formScreen(navController: NavController) {
    composable("$formRoute/{$profileIdArgument}") { backStackEntry ->
        val viewModel: PersonalProfileFormViewModel = koinViewModel()
        val uiState: PersonalProfileFormUiState by viewModel.uiState.collectAsState()

        backStackEntry.arguments?.getString(profileIdArgument)?.let { id ->
            if (id != "null" && !viewModel.isSearchPerformed()) {
                viewModel.searchById(id)
            }
        }

        PersonalProfileFormScreen(uiState = uiState, navController = navController)
    }
}

fun NavController.navigateToForm(id: String?) {
    navigate("$formRoute/$id")
}