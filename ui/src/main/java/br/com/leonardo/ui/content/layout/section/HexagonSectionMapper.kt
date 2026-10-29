package br.com.leonardo.ui.content.layout.section

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

/**
 * Hexagon section mapper
 *
 * @param S
 * @param UI
 * @param R
 */
interface HexagonSectionMapper< S : HexagonState, UI : HexagonUIState, R : HexagonSectionRender> {

    /**
     * Converts
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param state
     * @param uiState the ui state
     * @return the r
     */
    @Composable
    fun map(
        state: S,
        uiState: UI
    ): R

}