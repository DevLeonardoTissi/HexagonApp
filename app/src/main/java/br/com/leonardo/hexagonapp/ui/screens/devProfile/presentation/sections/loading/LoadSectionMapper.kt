package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.loading

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class LoadSectionMapper : HexagonSectionMapper<DevProfileState, DevProfileUIState, HexagonSectionRender> {
    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState,
    ): HexagonSectionRender = object : HexagonSectionRender {}
}
