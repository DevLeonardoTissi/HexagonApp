package br.com.leonardo.ui.content.provider

import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

/**
 * Hexagon content provider
 *
 * @param S
 * @param UI
 */
interface HexagonContentProvider<S: HexagonState, UI: HexagonUIState> {

    /**
     * Returns the contents
     *
     * @param state
     * @param uiState the ui state
     * @return the hexagon contents
     */
    fun getContent(
        state: S,
        uiState: UI
    ): List<HexagonContent> = listOf()
}
