package br.com.leonardo.appcore.presentation.content.provider

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonContent
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState

/**
 * Hexagon scaffold content provider
 *
 * @param S
 * @param UI
 * @constructor Creates a new HexagonScaffoldContentProvider
 * @property topContent the top content
 * @property bottomContent the bottom content
 * @property contentContent the content content
 */
abstract class HexagonScaffoldContentProvider<S : HexagonState, UI : HexagonUIState>(
    open val topContent: HexagonContentProvider<S, UI>? = null,
    open val bottomContent: HexagonContentProvider<S, UI>? = null,
    open val contentContent: HexagonContentProvider<S, UI>? = null,
) : HexagonContentProvider<S, UI> {
    override fun getContent(
        state: S,
        uiState: UI,
    ): List<HexagonContent> = contentContent?.getContent(state, uiState) ?: emptyList()
}
