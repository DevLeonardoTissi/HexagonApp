package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.user

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSection

class UserSection : HexagonSection<DevProfileState, DevProfileUIState, UserSectionRender>(
    view = UserSectionView(),
    mapper = UserSectionMapper()
)