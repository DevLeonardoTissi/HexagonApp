package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSection
import br.com.leonardo.ui.content.layout.section.HexagonSectionRender

class LoadSection: HexagonSection<DevProfileState, DevProfileUIState, HexagonSectionRender>(
    view = LoadSectionView(),
    mapper = LoadSectionMapper()
)