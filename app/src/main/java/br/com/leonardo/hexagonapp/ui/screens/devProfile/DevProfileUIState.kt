package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.ui.screens.utils.HexagonUIState
import br.com.leonardo.hexagonapp.utils.DevProfileScreenState

data class DevProfileUIState(
    val screenState: DevProfileScreenState = DevProfileScreenState.Loading,
    val refreshing: Boolean = false,
    val showBottomSheetShareProfile: Boolean = false,
): HexagonUIState