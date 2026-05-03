package br.com.leonardo.hexagonapp.ui.screens.main

import br.com.leonardo.ui.data.uidata.HexagonUIData
import br.com.leonardo.ui.navigator.Route

class MainScreenUiData(initialState: MainScreenUiState) :
    HexagonUIData<MainScreenUiState>(initialState) {

    fun setDarkModeTheme(isDarkMode: Boolean) {
        updateUIState { it.copy(isDarkMode = isDarkMode) }
    }

    fun updateBottomSheetVisibility(visible: Boolean) {
        updateUIState { it.copy(visibilityBottomSheetConfig = visible) }
    }

    fun updateCurrentRoute(route: Route) {
        updateUIState { it.copy(currentRoute = route) }
    }


}