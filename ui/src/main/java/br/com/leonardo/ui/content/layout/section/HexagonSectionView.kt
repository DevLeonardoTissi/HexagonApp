package br.com.leonardo.ui.content.layout.section

import androidx.compose.runtime.Composable
import br.com.leonardo.ui.action.HexagonAction

abstract class HexagonSectionView<R : HexagonSectionRender> {

    @Composable
    open fun Show(
        render: R,
        onActions: (HexagonAction) -> Unit
    ) {

    }


}