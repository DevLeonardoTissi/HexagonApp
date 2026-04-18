package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.utils.DevProfileScreenState
import br.com.leonardo.ui.data.uistate.HexagonRefreshableUIState

data class DevProfileUIState(
    override val isRefreshing: Boolean = false,
    val screenState: DevProfileScreenState = DevProfileScreenState.Loading,
    val showBottomSheetShareProfile: Boolean = false,
): HexagonRefreshableUIState