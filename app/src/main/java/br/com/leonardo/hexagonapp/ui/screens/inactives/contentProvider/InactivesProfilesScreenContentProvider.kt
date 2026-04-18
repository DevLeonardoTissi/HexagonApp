package br.com.leonardo.hexagonapp.ui.screens.inactives.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.InactivesProfilesUiState
import br.com.leonardo.ui.content.provider.HexagonContentProvider
import br.com.leonardo.ui.content.provider.HexagonScaffoldContentProvider

class InactivesProfilesScreenContentProvider(
    override val contentContent: HexagonContentProvider<InactivesProfilesState, InactivesProfilesUiState>? = InactivesProfilesScreenContentContentProvider()
) : HexagonScaffoldContentProvider<InactivesProfilesState, InactivesProfilesUiState>()