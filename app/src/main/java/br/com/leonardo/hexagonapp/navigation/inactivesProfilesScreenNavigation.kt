package br.com.leonardo.hexagonapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesActions
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesViewModel
import br.com.leonardo.hexagonapp.ui.screens.inactives.contentLayout.InactivesProfilesScreenContentLayout
import br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider.InactivesProfilesScreenContentProvider
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object InactiveRoute

fun NavGraphBuilder.inactivesScreen(navController: NavController) {
    composable<InactiveRoute> {

        val viewModel: InactivesProfilesViewModel = koinViewModel()
        val state: InactivesProfilesState by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: InactivesProfilesUiState by viewModel.uiData.uiState.collectAsStateWithLifecycle()

        val contentLayout = InactivesProfilesScreenContentLayout()
        val contentProvider = InactivesProfilesScreenContentProvider()

        contentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = contentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { inactivesActions ->
                (inactivesActions as? InactivesProfilesActions)?.let {
                    viewModel.handleAction(it)
                }
            }
        )

//        InactiveScreen(uiState = uiState, onClickItem = { id ->
//            navController.navigate(FormRoute(id))
//        }, onDelete = { profile ->
//            viewModel.remove(profile)
//        }, onUpdate = { profile -> viewModel.update(profile) }
//        )
    }
}
