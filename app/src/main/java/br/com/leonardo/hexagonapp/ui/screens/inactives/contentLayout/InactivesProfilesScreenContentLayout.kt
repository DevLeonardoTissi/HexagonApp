package br.com.leonardo.hexagonapp.ui.screens.inactives.contentLayout

import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.ui.content.layout.content.HexagonBaseContentLayout
import br.com.leonardo.ui.content.layout.content.scaffold.HexagonScaffoldContentLayout

class InactivesProfilesScreenContentLayout(
    override val contentLayout: HexagonBaseContentLayout<InactivesProfilesState, InactivesProfilesUiState>? = InactivesProfilesScreenContentContentLayout()
) : HexagonScaffoldContentLayout<InactivesProfilesState, InactivesProfilesUiState>()