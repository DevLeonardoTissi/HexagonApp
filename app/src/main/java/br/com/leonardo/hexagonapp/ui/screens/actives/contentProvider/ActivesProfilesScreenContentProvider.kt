package br.com.leonardo.hexagonapp.ui.screens.actives.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.content.provider.HexagonScaffoldContentProvider

class ActivesProfilesScreenContentProvider(
    override val contentContent: HexagonContentProvider<ActivesProfilesState, ActivesProfilesUiState>? = ActivesProfilesScreenContentContentProvider()
) : HexagonScaffoldContentProvider<ActivesProfilesState, ActivesProfilesUiState>()