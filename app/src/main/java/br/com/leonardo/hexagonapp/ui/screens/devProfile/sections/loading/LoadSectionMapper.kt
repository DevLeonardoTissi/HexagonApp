package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper
import br.com.leonardo.ui.content.layout.section.HexagonSectionRender

class LoadSectionMapper :
    HexagonSectionMapper<DevProfileState, DevProfileUIState, HexagonSectionRender> {
    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState
    ): HexagonSectionRender {
        return  object : HexagonSectionRender{}
    }
}