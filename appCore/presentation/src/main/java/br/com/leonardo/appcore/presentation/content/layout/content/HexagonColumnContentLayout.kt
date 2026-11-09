package br.com.leonardo.appcore.presentation.content.layout.content

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState

/**
 * Hexagon column content layout
 *
 * @param S
 * @param UI
 * @constructor Creates a new HexagonColumnContentLayout
 * @property horizontalAlignment the horizontal alignment
 */
open class HexagonColumnContentLayout<S : HexagonState, UI : HexagonUIState>(
    open val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
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
            modifier = modifier,
        ) {
            contentProvider
                ?.getContent(
                    state = state,
                    uiState = uiState,
                )?.forEach { content ->
                    content.Show(
                        state = state,
                        uiState = uiState,
                        onActions = onActions,
                    )
                }
        }
    }
}
