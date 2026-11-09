package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.sections.inactivesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState

class InactivesProfilesListSectionMapper :
    HexagonSectionMapper<InactivesProfilesState, InactivesProfilesUiState, InactivesProfilesListSectionRender> {
    @Composable
    override fun map(
        state: InactivesProfilesState,
        uiState: InactivesProfilesUiState,
    ): InactivesProfilesListSectionRender =
        with(state) {
            InactivesProfilesListSectionRender(inactivesProfilesList = inactiveList)
        }
}
