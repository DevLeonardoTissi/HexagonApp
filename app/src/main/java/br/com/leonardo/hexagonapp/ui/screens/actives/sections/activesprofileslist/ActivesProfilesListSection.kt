package br.com.leonardo.hexagonapp.ui.screens.actives.sections.activesprofileslist

import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.ui.content.layout.section.HexagonSection

class ActivesProfilesListSection :
    HexagonSection<ActivesProfilesState, ActivesProfilesUiState, ActivesProfilesListSectionRender>(
        mapper = ActivesProfilesListSectionMapper(),
        view = ActivesProfilesListSectionView()
    )