package br.com.leonardo.ui.content.provider

import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

abstract class HexagonScaffoldContentProvider<S : HexagonState, UI : HexagonUIState>(
    open val topContent: HexagonContentProvider<S, UI>? = null,
    open val bottomContent: HexagonContentProvider<S, UI>? = null,
    open val contentContent: HexagonContentProvider<S, UI>? = null,
) : HexagonContentProvider<S, UI>{

    override fun getContent(state: S, uiState: UI): List<HexagonContent> {
        return contentContent?.getContent(state, uiState) ?: emptyList()
    }


}