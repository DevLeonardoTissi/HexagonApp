package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation

import br.com.leonardo.appcore.presentation.data.uistate.HexagonRefreshableUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.model.DevProfileScreenState

data class DevProfileUIState(
    override val isRefreshing: Boolean = false,
    val screenState: DevProfileScreenState = DevProfileScreenState.Loading,
    val showBottomSheetShareProfile: Boolean = false,
) : HexagonRefreshableUIState
