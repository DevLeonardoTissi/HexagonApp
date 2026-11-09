package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.presentation.data.uidata.HexagonUIData
import br.com.leonardo.appcore.presentation.navigator.Route

/** UI Data holder for [MainScreenUiState]. */
class MainScreenUiData(
    initialState: MainScreenUiState,
) : HexagonUIData<MainScreenUiState>(initialState) {
    /** Updates dark mode UI theme state. */
    fun setDarkModeTheme(isDarkMode: Boolean) {
        updateUIState { it.copy(isDarkMode = isDarkMode) }
    }

    /** Updates settings bottom sheet visibility state. */
    fun updateBottomSheetVisibility(visible: Boolean) {
        updateUIState { it.copy(visibilityBottomSheetConfig = visible) }
    }

    /** Updates currently displayed route in state. */
    fun updateCurrentRoute(route: Route) {
        updateUIState { it.copy(currentRoute = route) }
    }
}
