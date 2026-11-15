package br.com.leonardo.appcore.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.leonardo.appcore.presentation.action.ActivityHandler
import br.com.leonardo.appcore.presentation.action.HandleAction
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState
import br.com.leonardo.appcore.presentation.navigator.SubfeatureInnerRoute
import br.com.leonardo.appcore.presentation.viewmodel.HexagonViewModel
import org.koin.core.component.KoinScopeComponent
import org.koin.core.scope.Scope

/**
 * Hexagon screen
 *
 * @param R
 * @param S
 * @param UIS
 * @param VM
 * @param CL
 * @param CP
 * @constructor Creates a new HexagonScreen
 */
abstract class HexagonScreen<
    R : SubfeatureInnerRoute,
    S : HexagonState,
    UIS : HexagonUIState,
    VM : HexagonViewModel<S, *, UIS, *>,
    CL : HexagonBaseContentLayout<S, UIS>,
    CP : HexagonContentProvider<S, UIS>,
> : KoinScopeComponent {
    private var _scope: Scope? = null

    override val scope: Scope
        get() {
            val currentScope = _scope
            if (currentScope == null || currentScope.closed) {
                return getKoin().createScope(this).also { _scope = it }
            }
            return currentScope
        }

    /**
     * Provide view model
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param arguments
     * @return the vm
     */
    @Composable
    protected abstract fun provideViewModel(arguments: R?): VM

    private val provideContentLayout: HexagonBaseContentLayout<S, UIS>
        get() = scope.get()

    private val provideContentProvider: HexagonContentProvider<S, UIS>
        get() = scope.get()

    var viewModel: VM? = null

    /**
     * Content
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param arguments
     */
    @Composable
    fun Content(arguments: R? = null) {
        val context = LocalContext.current
        val activityHandler = (context as? KoinScopeComponent)?.scope?.getOrNull<ActivityHandler>()

        viewModel = provideViewModel(arguments)
        viewModel?.let {
            it.setObserver(
                object : HandleAction {
                    override fun handleAction(action: HexagonAction) {
                        onAction(action, activityHandler)
                    }
                },
            )
            it.onDestroy = {
                if (_scope?.closed == false) {
                    _scope?.close()
                }
            }
            val state: S by it.data.state.collectAsStateWithLifecycle()
            val uiState: UIS by it.uiData.uiState.collectAsStateWithLifecycle()
            provideContentLayout.Layout(
                state = state,
                uiState = uiState,
                contentProvider = provideContentProvider,
                modifier = Modifier.fillMaxSize(),
                onActions = { action ->
                    onAction(action, activityHandler)
                },
            )
        }
    }

    private fun onAction(
        action: HexagonAction,
        activityHandler: ActivityHandler?,
    ) {
        activityHandler?.handleScreenAction(action)
        viewModel?.handleAction(action)
        handleAction(action)
    }

    /**
     * Handles the action
     *
     * @param action
     */
    open fun handleAction(action: HexagonAction) {}
}
