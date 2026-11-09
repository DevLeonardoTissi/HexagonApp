package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentLayout

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.appcore.presentation.content.layout.content.scaffold.HexagonScaffoldContentLayout
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState

class InactivesProfilesScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<InactivesProfilesState, InactivesProfilesUiState>? =
        InactivesProfilesScreenContentContentLayout(),
) : HexagonScaffoldContentLayout<InactivesProfilesState, InactivesProfilesUiState>()
