package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.error

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class ErrorSection :
    HexagonSection<DevProfileState, DevProfileUIState, ErrorSectionRender>(
        view = ErrorSectionView(),
        mapper = ErrorSectionMapper(),
    )
