package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.contentLayout

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.layout.content.scaffold.HexagonScaffoldContentLayout
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesUiState

class ActivesProfilesScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<ActivesProfilesState, ActivesProfilesUiState>? =
        ActivesProfilesScreenContentContentLayout(),
) : HexagonScaffoldContentLayout<ActivesProfilesState, ActivesProfilesUiState>()
