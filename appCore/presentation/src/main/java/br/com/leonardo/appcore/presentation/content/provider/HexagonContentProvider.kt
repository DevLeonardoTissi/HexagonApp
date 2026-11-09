package br.com.leonardo.appcore.presentation.content.provider

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonContent
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState

/**
 * Hexagon content provider
 *
 * @param S
 * @param UI
 */
interface HexagonContentProvider<S : HexagonState, UI : HexagonUIState> {
    /**
     * Returns the contents
     *
     * @param state
     * @param uiState the ui state
     * @return the hexagon contents
     */
    fun getContent(
        state: S,
        uiState: UI,
    ): List<HexagonContent> = listOf()
}
