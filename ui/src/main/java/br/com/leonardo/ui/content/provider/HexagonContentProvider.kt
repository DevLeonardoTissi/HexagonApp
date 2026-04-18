package br.com.leonardo.ui.content.provider

import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

interface HexagonContentProvider<S: HexagonState, UI: HexagonUIState> {

    fun getContent(
        state: S,
        uiState: UI
    ): List<HexagonContent> = listOf()
}