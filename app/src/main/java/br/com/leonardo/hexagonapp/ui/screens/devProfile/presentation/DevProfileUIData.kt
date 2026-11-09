package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation

import br.com.leonardo.appcore.presentation.data.uidata.HexagonUIData
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.model.DevProfileScreenState

class DevProfileUIData(
    initialState: DevProfileUIState,
) : HexagonUIData<DevProfileUIState>(initialValue = initialState) {
    fun error() {
        updateUIState {
            it.copy(screenState = DevProfileScreenState.Error)
        }
    }

    fun success() {
        updateUIState { it.copy(screenState = DevProfileScreenState.Success) }
    }

    fun refresh(refresh: Boolean) {
        updateUIState { it.copy(isRefreshing = refresh) }
    }

    fun load() {
        updateUIState { it.copy(screenState = DevProfileScreenState.Loading) }
    }

    fun updateBottomSheetShareProfileVisibility(show: Boolean) {
        updateUIState { it.copy(showBottomSheetShareProfile = show) }
    }
}
