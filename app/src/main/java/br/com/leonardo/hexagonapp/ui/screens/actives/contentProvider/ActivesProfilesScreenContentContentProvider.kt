package br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.actives.sections.activesprofileslist.ActivesProfilesListSection
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.inactives.sections.inactivesprofileslist.InactivesProfilesListSection
import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.content.provider.HexagonContentProvider

class ActivesProfilesScreenContentContentProvider : HexagonContentProvider<ActivesProfilesState, ActivesProfilesUiState> {

    override fun getContent(
        state: ActivesProfilesState,
        uiState: ActivesProfilesUiState
    ): List<HexagonContent> {
       return listOf(ActivesProfilesListSection())
    }


}