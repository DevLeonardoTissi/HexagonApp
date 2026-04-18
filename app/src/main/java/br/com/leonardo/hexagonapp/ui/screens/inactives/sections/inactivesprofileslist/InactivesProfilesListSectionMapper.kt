package br.com.leonardo.hexagonapp.ui.screens.inactives.sections.inactivesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class InactivesProfilesListSectionMapper :
    HexagonSectionMapper<InactivesProfilesState, InactivesProfilesUiState, InactivesProfilesListSectionRender> {
    @Composable
    override fun map(
        state: InactivesProfilesState,
        uiState: InactivesProfilesUiState
    ): InactivesProfilesListSectionRender =
        with(state) {
            InactivesProfilesListSectionRender(inactivesProfilesList = inactiveList)
        }
}