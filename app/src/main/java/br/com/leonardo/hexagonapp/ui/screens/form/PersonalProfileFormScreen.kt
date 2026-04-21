package br.com.leonardo.hexagonapp.ui.screens.form

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.leonardo.hexagonapp.ui.screens.form.contentLayout.PersonalProfileFormScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.form.contentProvider.PersonalProfileFormScreenContentProvider
import br.com.leonardo.ui.screen.HexagonScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class PersonalProfileFormScreen : HexagonScreen {

    @Serializable
    data class FormRoute(val profileId: String? = null)

    override fun registerScreen(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable<FormRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<FormRoute>()
            Content(route.profileId)
        }
    }

    @Composable
    override fun Content(arguments: Any?) {
        val id = arguments as? String
        val viewModel: PersonalProfileFormViewModel = koinViewModel<PersonalProfileFormViewModel>(
            parameters = { parametersOf(id) }
        )
        val state: PersonalProfileFormState by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: PersonalProfileFormUIState by viewModel.uiData.uiState.collectAsStateWithLifecycle()

        val contentLayout = PersonalProfileFormScreenContentLayout()
        val contentProvider = PersonalProfileFormScreenContentProvider()

        contentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = contentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { formActions ->
                (formActions as? PersonalProfileFormActions)?.let {
                    viewModel.executeAction(it)
                }
            }
        )
    }
}