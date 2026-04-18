package br.com.leonardo.hexagonapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesActions
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.actives.contentLayout.ActivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider.ActivesProfilesScreenContentProvider
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object HomeRoute

fun NavGraphBuilder.activesScreen(navController: NavController) {
    composable<HomeRoute> {

        val viewModel: ActivesProfilesViewModel = koinViewModel()
        val state: ActivesProfilesState by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: ActivesProfilesUiState by viewModel.uiData.uiState.collectAsStateWithLifecycle()

        val contentLayout = ActivesProfilesScreenContentLayout()
        val contentProvider = ActivesProfilesScreenContentProvider()

        contentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = contentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { activesActions ->
                (activesActions as? ActivesProfilesActions)?.let {
                    viewModel.handleAction(it)
                }
            }
        )
    }
}

