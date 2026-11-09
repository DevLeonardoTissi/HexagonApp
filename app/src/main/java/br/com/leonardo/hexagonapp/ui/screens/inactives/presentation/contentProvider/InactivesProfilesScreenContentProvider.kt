package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.appcore.presentation.content.provider.HexagonScaffoldContentProvider
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesState
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesUiState

class InactivesProfilesScreenContentProvider(
    override val contentContent: HexagonContentProvider<InactivesProfilesState, InactivesProfilesUiState>? =
        InactivesProfilesScreenContentContentProvider(),
) : HexagonScaffoldContentProvider<InactivesProfilesState, InactivesProfilesUiState>()
