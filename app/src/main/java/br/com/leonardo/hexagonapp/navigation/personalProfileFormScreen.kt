package br.com.leonardo.hexagonapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormScreen
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUiState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

internal const  val formRoute = "form"
internal const val profileIdArgument = "id"

fun NavGraphBuilder.formScreen(navController: NavController) {
    composable("$formRoute?$profileIdArgument={$profileIdArgument}") {
        val id = navArgument(profileIdArgument){
            nullable = true
        }
        val viewModel: PersonalProfileFormViewModel = koinViewModel<PersonalProfileFormViewModel>(
            parameters = { parametersOf(id) }
        )
        val uiState: PersonalProfileFormUiState by viewModel.uiState.collectAsState()
        PersonalProfileFormScreen(uiState = uiState, navController = navController)
    }
}

fun NavController.navigateToEdit(id: String) {
    navigate("$formRoute?$profileIdArgument=$id")
}
fun NavController.navigateToForm(){
    navigate(formRoute)
}

