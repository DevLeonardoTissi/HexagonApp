package br.com.leonardo.appcore.presentation.content.layout.content.empty

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState

/**
 * Hexagon empty layout
 *
 * @param S
 * @param UI
 * @constructor Creates a new HexagonEmptyLayout
 */
class HexagonEmptyLayout<S : HexagonState, UI : HexagonUIState> : HexagonBaseContentLayout<S, UI> {
    @Composable
    override fun Layout(
        state: S,
        uiState: UI,
        contentProvider: HexagonContentProvider<S, UI>?,
        onActions: (HexagonAction) -> Unit,
        modifier: Modifier,
    ) {
    }
}
