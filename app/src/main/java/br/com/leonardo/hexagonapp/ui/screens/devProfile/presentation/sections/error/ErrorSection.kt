package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection

class ErrorSection : HexagonSection<DevProfileState, DevProfileUIState, ErrorSectionRender>(
    view = ErrorSectionView(),
    mapper = ErrorSectionMapper()
)
