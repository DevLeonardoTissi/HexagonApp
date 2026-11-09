package br.com.leonardo.appcore.presentation.content.layout.section

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.action.HexagonAction

/**
 * Hexagon section view
 *
 * @param R
 * @constructor Creates a new HexagonSectionView
 */
abstract class HexagonSectionView<R : HexagonSectionRender> {
    /**
     * Displays
     * Composable function — emits UI and is re-invoked (recomposed) when its inputs change.
     *
     * @param render
     * @param onActions the on actions
     * @receiver
     */
    @Composable
    open fun Show(
        render: R,
        onActions: (HexagonAction) -> Unit,
    ) {
    }
}
