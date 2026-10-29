package br.com.leonardo.ui.content.layout.content

import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonRefreshableUIState

/**
 * Hexagon swipe refresh content layout
 *
 * @param S
 * @param UI
 * @constructor Creates a new HexagonSwipeRefreshContentLayout
 * @property contentLayout the content layout
 */
abstract class HexagonSwipeRefreshContentLayout<S : HexagonState, UI : HexagonRefreshableUIState>(
    open val contentLayout: HexagonBaseContentLayout<S, UI> = HexagonColumnContentLayout()
) : HexagonBaseContentLayout<S, UI> {
    abstract val onRefreshAction: HexagonAction

    @Composable
    override fun Layout(
        state: S,
        uiState: UI,
        contentProvider: HexagonContentProvider<S, UI>?,
        onActions: (HexagonAction) -> Unit,
        modifier: Modifier,
    ) {
        PullToRefreshBox(
            isRefreshing = uiState.isRefreshing,
            onRefresh = {
                onActions(
                    onRefreshAction
                )
            },
            modifier = modifier
        ) {
            contentLayout.Layout(
                state = state,
                uiState = uiState,
                contentProvider = contentProvider,
                onActions = onActions,
                modifier = Modifier.contentSwipeModifier(state, uiState)
            )
        }
    }

    /**
     * Content swipe modifier on the receiver [Modifier]
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param state
     * @param uiState the ui state
     * @return the modifier
     */
    @Composable
    open fun Modifier.contentSwipeModifier(state: S, uiState: UI) : Modifier = this

}
