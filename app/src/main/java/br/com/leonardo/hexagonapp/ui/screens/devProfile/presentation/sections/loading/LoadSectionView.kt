package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.loading

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionView
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.loading.components.DevProfileShimmerScreen

class LoadSectionView : HexagonSectionView<HexagonSectionRender>() {
    @Composable
    override fun Show(
        render: HexagonSectionRender,
        onActions: (HexagonAction) -> Unit,
    ) {
        DevProfileShimmerScreen()
    }
}
