package br.com.leonardo.hexagonapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesActions
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileActions
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileViewModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentLayout.DevProfileScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.devProfile.contentProvider.DevProfileScreenContentProvider
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object DevProfileRoute

fun NavGraphBuilder.devProfileScreen() {
    composable<DevProfileRoute> {

        val viewModel: DevProfileViewModel = koinViewModel()
        val state: DevProfileState by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: DevProfileUIState by viewModel.uiData.uiState.collectAsStateWithLifecycle()
        val contentLayout = DevProfileScreenContentLayout()
        val contentProvider = DevProfileScreenContentProvider()

        contentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = contentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { devProfileScreenAction ->
                (devProfileScreenAction as? DevProfileActions)?.let {
                    viewModel.handleAction(it)
                }

            }
        )
    }
}
