package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.user

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class UserSection :
    HexagonSection<DevProfileState, DevProfileUIState, UserSectionRender>(
        view = UserSectionView(),
        mapper = UserSectionMapper(),
    )
