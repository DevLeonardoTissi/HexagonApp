package br.com.leonardo.hexagonapp.ui.screens.main

import br.com.leonardo.hexagonapp.ui.screens.inactives.navigator.route.InactiveRoute
import br.com.leonardo.ui.data.uistate.HexagonUIState
import br.com.leonardo.ui.navigator.Route

data class MainScreenUiState(
    val currentRoute: Route = InactiveRoute,
    val isDarkMode: Boolean = false,
    val visibilityBottomSheetConfig: Boolean = false,
) : HexagonUIState