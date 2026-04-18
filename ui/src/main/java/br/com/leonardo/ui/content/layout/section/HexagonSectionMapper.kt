package br.com.leonardo.ui.content.layout.section

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

interface HexagonSectionMapper< S : HexagonState, UI : HexagonUIState, R : HexagonSectionRender> {

    @Composable
    fun map(
        state: S,
        uiState: UI
    ): R

}