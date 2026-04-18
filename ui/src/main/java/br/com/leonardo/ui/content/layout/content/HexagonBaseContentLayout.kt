package br.com.leonardo.ui.content.layout.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

interface HexagonBaseContentLayout<S, UI> where S: HexagonState, UI : HexagonUIState {

    @Composable
    fun Layout(
        state:S,
        uiState:UI,
        contentProvider: HexagonContentProvider<S, UI>?,
        onActions: (HexagonAction) -> Unit,
        modifier : Modifier = Modifier,
    ){

    }

}