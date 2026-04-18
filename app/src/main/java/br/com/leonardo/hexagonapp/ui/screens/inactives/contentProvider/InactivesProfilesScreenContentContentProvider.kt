package br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.sections.inactivesprofileslist.InactivesProfilesListSection
import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.content.provider.HexagonContentProvider

class InactivesProfilesScreenContentContentProvider : HexagonContentProvider<InactivesProfilesState, InactivesProfilesUiState> {

    override fun getContent(
        state: InactivesProfilesState,
        uiState: InactivesProfilesUiState
    ): List<HexagonContent> {
       return listOf(InactivesProfilesListSection())
    }


}