package br.com.leonardo.hexagonapp.ui.screens.actives.contentLayout

import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesUiState
import br.com.leonardo.ui.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.ui.content.layout.content.scaffold.HexagonScaffoldContentLayout

class ActivesProfilesScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<ActivesProfilesState, ActivesProfilesUiState>? = ActivesProfilesScreenContentContentLayout()
) : HexagonScaffoldContentLayout<ActivesProfilesState, ActivesProfilesUiState>()