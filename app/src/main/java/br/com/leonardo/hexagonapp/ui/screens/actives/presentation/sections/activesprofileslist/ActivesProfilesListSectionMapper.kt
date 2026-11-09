package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.sections.activesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState

class ActivesProfilesListSectionMapper :
    HexagonSectionMapper<ActivesProfilesState, ActivesProfilesUiState, ActivesProfilesListSectionRender> {
    @Composable
    override fun map(
        state: ActivesProfilesState,
        uiState: ActivesProfilesUiState,
    ): ActivesProfilesListSectionRender =
        with(state) {
            ActivesProfilesListSectionRender(activesProfilesList = activeList)
        }
}
