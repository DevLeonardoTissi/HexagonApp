package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonContent
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.sections.inactivesprofileslist.InactivesProfilesListSection

class InactivesProfilesScreenContentContentProvider :
    HexagonContentProvider<InactivesProfilesState, InactivesProfilesUiState> {
    override fun getContent(
        state: InactivesProfilesState,
        uiState: InactivesProfilesUiState,
    ): List<HexagonContent> = listOf(InactivesProfilesListSection())
}
