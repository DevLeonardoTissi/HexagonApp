package br.com.leonardo.ui.content.layout.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

/**
 * Hexagon base content layout
 *
 * @param S
 * @param UI
 */
interface HexagonBaseContentLayout<S, UI> where S: HexagonState, UI : HexagonUIState {

    /**
     * Layout
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param state
     * @param uiState the ui state
     * @param contentProvider the content provider
     * @param onActions the on actions
     * @receiver
     * @param modifier
     */
    @Composable
    fun Layout(
        state:S,
        uiState:UI,
        contentProvider: HexagonContentProvider<S, UI>?,
        onActions: (HexagonAction) -> Unit,
        modifier : Modifier = Modifier,
    ){

    }

}
