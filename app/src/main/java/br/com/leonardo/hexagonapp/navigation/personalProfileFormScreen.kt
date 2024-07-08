package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUiState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
data class FormRoute (val profileId : String? = null)

fun NavGraphBuilder.formScreen(navController: NavController) {
    composable<FormRoute> { backStackEntry ->
        val id = backStackEntry.toRoute<FormRoute>().profileId
        val viewModel: PersonalProfileFormViewModel = koinViewModel<PersonalProfileFormViewModel>(
            parameters = { parametersOf(id) }
        )
        val uiState: PersonalProfileFormUiState by viewModel.uiState.collectAsState()
        PersonalProfileFormScreen(uiState = uiState, onPopBackStack = {
                navController.navigateUp()
        })
    }
}

