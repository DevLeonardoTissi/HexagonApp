package br.com.leonardo.ui.content.layout.content

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState


open class HexagonColumnContentLayout<S : HexagonState, UI : HexagonUIState>(
    open val horizontalAlignment: Alignment.Horizontal = Alignment.Start
) : HexagonBaseContentLayout<S, UI> {

    @Composable
    override fun Layout(
        state: S,
        uiState: UI,
        contentProvider: HexagonContentProvider<S, UI>?,
        onActions: (HexagonAction) -> Unit,
        modifier: Modifier,
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            modifier = modifier
        ) {
            contentProvider?.getContent(
                state = state,
                uiState = uiState
            )?.forEach { content ->
                content.Show(
                    state = state,
                    uiState = uiState,
                    onActions = onActions
                )
            }
        }
    }
}