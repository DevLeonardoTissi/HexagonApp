package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState
import br.com.leonardo.appcore.presentation.navigator.Route
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.navigation.route.InactiveRoute

data class MainScreenUiState(
    val currentRoute: Route = InactiveRoute,
    val isDarkMode: Boolean = false,
    val visibilityBottomSheetConfig: Boolean = false,
) : HexagonUIState
