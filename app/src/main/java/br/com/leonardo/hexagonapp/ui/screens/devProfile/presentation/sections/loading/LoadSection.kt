package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.loading

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class LoadSection :
    HexagonSection<DevProfileState, DevProfileUIState, HexagonSectionRender>(
        view = LoadSectionView(),
        mapper = LoadSectionMapper(),
    )
