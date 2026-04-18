package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.utils.DevProfileScreenState
import br.com.leonardo.ui.data.uidata.HexagonUIData

class DevProfileUIData(initialState: DevProfileUIState) :
    HexagonUIData<DevProfileUIState>(initialValue = initialState) {

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


}