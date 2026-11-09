package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.sections.activesprofileslist

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState

class ActivesProfilesListSection :
    HexagonSection<ActivesProfilesState, ActivesProfilesUiState, ActivesProfilesListSectionRender>(
        mapper = ActivesProfilesListSectionMapper(),
        view = ActivesProfilesListSectionView(),
    )
