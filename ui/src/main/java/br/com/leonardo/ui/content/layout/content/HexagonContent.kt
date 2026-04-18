package br.com.leonardo.ui.content.layout.content

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

interface HexagonContent {

    @Composable
    fun Show(
        state: HexagonState,
        uiState: HexagonUIState,
        onActions: (HexagonAction) -> Unit
    ){

    }

}