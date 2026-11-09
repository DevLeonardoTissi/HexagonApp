package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.content.provider.HexagonScaffoldContentProvider
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState

class ActivesProfilesScreenContentProvider(
    override val contentContent: HexagonContentProvider<ActivesProfilesState, ActivesProfilesUiState>? =
        ActivesProfilesScreenContentContentProvider(),
) : HexagonScaffoldContentProvider<ActivesProfilesState, ActivesProfilesUiState>()
