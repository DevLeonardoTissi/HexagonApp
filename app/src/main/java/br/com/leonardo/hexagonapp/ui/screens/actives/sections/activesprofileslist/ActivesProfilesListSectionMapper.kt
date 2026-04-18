package br.com.leonardo.hexagonapp.ui.screens.actives.sections.activesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class ActivesProfilesListSectionMapper :
    HexagonSectionMapper<ActivesProfilesState, ActivesProfilesUiState, ActivesProfilesListSectionRender> {
    @Composable
    override fun map(
        state: ActivesProfilesState,
        uiState: ActivesProfilesUiState
    ): ActivesProfilesListSectionRender =
        with(state) {
            ActivesProfilesListSectionRender(activesProfilesList = inactiveList)
        }
}