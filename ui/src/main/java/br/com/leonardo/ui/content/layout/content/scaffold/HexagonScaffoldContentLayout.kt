package br.com.leonardo.ui.content.layout.content.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.ui.content.layout.content.empty.HexagonEmptyLayout
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.content.provider.HexagonScaffoldContentProvider
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uistate.HexagonUIState

abstract class HexagonScaffoldContentLayout<S : HexagonState, UI : HexagonUIState>(
    open val topLayout: HexagonBaseContentLayout<S, UI>? = HexagonEmptyLayout(),
    open val bottomLayout: HexagonBaseContentLayout<S, UI>? = HexagonEmptyLayout(),
    open val contentLayout: HexagonBaseContentLayout<S, UI>? = HexagonEmptyLayout(),
    ) : HexagonBaseContentLayout<S, UI> {

    @Composable
    override fun Layout(
        state: S,
        uiState: UI,
        contentProvider: HexagonContentProvider<S, UI>?,
        onActions: (HexagonAction) -> Unit,
        modifier: Modifier
    ) {
        Scaffold(
            topBar = {
                (contentProvider as? HexagonScaffoldContentProvider)?.let { content ->
                    content.topContent?.let {
                        topLayout?.Layout(
                            state = state,
                            uiState = uiState,
                            contentProvider = content,
                            onActions = onActions,
                            modifier = Modifier.topModifier(state, uiState)
                        )
                    }
                }
            },
            bottomBar = {
                (contentProvider as? HexagonScaffoldContentProvider)?.let { content ->
                    content.bottomContent?.let {
                        bottomLayout?.Layout(
                            state = state,
                            uiState = uiState,
                            contentProvider = content,
                            onActions = onActions,
                            modifier = Modifier.bottomModifier(state, uiState)
                        )
                    }
                }
            }
        ) { innerPadding ->
            (contentProvider as? HexagonScaffoldContentProvider)?.let { content ->
                content.contentContent?.let {
                    contentLayout?.Layout(
                        state = state,
                        uiState = uiState,
                        contentProvider = content,
                        onActions = onActions,
                        modifier = Modifier
                            .padding(innerPadding)
                            .contentModifier(state, uiState)
                    )
                }
            }
        }
    }

    open fun Modifier.topModifier(state: S, uiState: UI): Modifier = this
    open fun Modifier.bottomModifier(state: S, uiState: UI): Modifier = this
    open fun Modifier.contentModifier(state: S, uiState: UI): Modifier = this

}