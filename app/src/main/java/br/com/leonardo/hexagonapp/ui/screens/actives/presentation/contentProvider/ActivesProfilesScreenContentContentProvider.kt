package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonContent
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.sections.activesprofileslist.ActivesProfilesListSection

class ActivesProfilesScreenContentContentProvider :
    HexagonContentProvider<ActivesProfilesState, ActivesProfilesUiState> {
    override fun getContent(
        state: ActivesProfilesState,
        uiState: ActivesProfilesUiState,
    ): List<HexagonContent> = listOf(ActivesProfilesListSection())
}
