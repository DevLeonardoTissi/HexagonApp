package br.com.leonardo.ui.content.layout.section

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

abstract class HexagonSection<S, UI, R>(
    private val view: HexagonSectionView<R>,
    private val mapper: HexagonSectionMapper<S, UI, R>
) : HexagonContent where S: HexagonState, UI: HexagonUIState, R: HexagonSectionRender {

    @Composable
    override fun Show(
        state: HexagonState,
        uiState: HexagonUIState,
        onActions: (HexagonAction) -> Unit
    ) {
        (state as? S)?.let { sectionState ->
            (uiState as? UI)?.let { sectionUiState ->
                view.Show(
                    render = mapper.map(
                        state = sectionState,
                        uiState = sectionUiState
                    ), onActions = onActions
                )
            }
        }
    }
}