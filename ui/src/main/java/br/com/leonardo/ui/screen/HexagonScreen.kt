package br.com.leonardo.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState
import br.com.leonardo.ui.navigator.Route
import br.com.leonardo.ui.viewmodel.HexagonViewModel
import org.koin.core.component.KoinComponent


abstract class HexagonScreen<
        R : Route,
        A : HexagonAction,
        S : HexagonState,
        UIS : HexagonUIState,
        VM : HexagonViewModel<A, S, *, UIS, *>,
        CL : HexagonBaseContentLayout<S, UIS>,
        CP : HexagonContentProvider<S, UIS>
        > : KoinComponent {

    @Composable
    protected abstract fun provideViewModel(
        arguments: R?
    ): VM

    abstract val provideContentLayout: CL

    abstract val provideContentProvider: CP

    @Composable
    fun Content(arguments: R? = null) {
        val viewModel: VM = provideViewModel(arguments)
        val state: S by viewModel.data.state.collectAsStateWithLifecycle()
        val uiState: UIS by viewModel.uiData.uiState.collectAsStateWithLifecycle()

        provideContentLayout.Layout(
            state = state,
            uiState = uiState,
            contentProvider = provideContentProvider,
            modifier = Modifier.fillMaxSize(),
            onActions = { action ->
                (action as? A)?.let {
                    viewModel.executeAction(it)
                }
            }
        )
    }
}