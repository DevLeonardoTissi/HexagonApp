package br.com.leonardo.ui.content.layout.content

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

/**
 * Hexagon content
 *
 */
interface HexagonContent {

    /**
     * Displays
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param state
     * @param uiState the ui state
     * @param onActions the on actions
     * @receiver
     */
    @Composable
    fun Show(
        state: HexagonState,
        uiState: HexagonUIState,
        onActions: (HexagonAction) -> Unit
    ){

    }

}
