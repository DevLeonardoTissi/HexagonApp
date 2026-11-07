package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading.components.DevProfileShimmerScreen
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionView

class LoadSectionView: HexagonSectionView<HexagonSectionRender>() {

    @Composable
    override fun Show(render: HexagonSectionRender, onActions: (HexagonAction) -> Unit) {
        DevProfileShimmerScreen()
    }

}
