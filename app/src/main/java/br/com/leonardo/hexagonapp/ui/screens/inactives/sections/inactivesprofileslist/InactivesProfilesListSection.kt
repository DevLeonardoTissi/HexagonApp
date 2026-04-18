package br.com.leonardo.hexagonapp.ui.screens.inactives.sections.inactivesprofileslist

import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.ui.content.layout.section.HexagonSection

class InactivesProfilesListSection :
    HexagonSection<InactivesProfilesState, InactivesProfilesUiState, InactivesProfilesListSectionRender>(
        mapper = InactivesProfilesListSectionMapper(),
        view = InactivesProfilesListSectionView()
    )