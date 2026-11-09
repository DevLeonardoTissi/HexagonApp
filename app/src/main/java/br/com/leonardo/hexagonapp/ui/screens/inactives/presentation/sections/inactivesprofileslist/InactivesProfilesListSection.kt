package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.sections.inactivesprofileslist

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState

class InactivesProfilesListSection :
    HexagonSection<InactivesProfilesState, InactivesProfilesUiState, InactivesProfilesListSectionRender>(
        mapper = InactivesProfilesListSectionMapper(),
        view = InactivesProfilesListSectionView(),
    )
