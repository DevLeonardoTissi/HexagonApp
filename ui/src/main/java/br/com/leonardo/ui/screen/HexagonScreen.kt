package br.com.leonardo.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.ui.action.HandleAction
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.action.HexagonNavigationAction
import br.com.leonardo.ui.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState
import br.com.leonardo.ui.navigator.HexagonNavigator
import br.com.leonardo.ui.navigator.Route
import br.com.leonardo.ui.viewmodel.HexagonViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


abstract class HexagonScreen<
        R : Route,
        S : HexagonState,
        UIS : HexagonUIState,
        VM : HexagonViewModel<S, *, UIS, *>,
        CL : HexagonBaseContentLayout<S, UIS>,
        CP : HexagonContentProvider<S, UIS>
        > : KoinComponent {

    private val navigator: HexagonNavigator by inject()

    @Composable
    protected abstract fun provideViewModel(
        arguments: R?
    ): VM

    abstract val provideContentLayout: CL

    abstract val provideContentProvider: CP

    var viewModel: VM? = null

    @Composable
    fun Content(arguments: R? = null) {
        viewModel = provideViewModel(arguments)
        viewModel?.let {
            it.setObserver(object : HandleAction {
                override fun handleAction(action: HexagonAction) {
                    onAction(action)
                }
            })
            val state: S by it.data.state.collectAsStateWithLifecycle()
            val uiState: UIS by it.uiData.uiState.collectAsStateWithLifecycle()
            provideContentLayout.Layout(
                state = state,
                uiState = uiState,
                contentProvider = provideContentProvider,
                modifier = Modifier.fillMaxSize(),
                onActions = { action ->
                    onAction(action)
                }
            )
        }
    }

    private fun onAction(action: HexagonAction) {
        if (action is HexagonNavigationAction) {
            navigator.handleNavigatorAction(action)
            return
        }
        viewModel?.handleAction(action)
        handleAction(action)
    }

    open fun handleAction(action: HexagonAction) {}
}
