package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.ui.screens.utils.HexagonUIData
import br.com.leonardo.hexagonapp.utils.DevProfileScreenState

class DevProfileUIData (initialState: DevProfileUIState) :
    HexagonUIData<DevProfileUIState>(initialValue = initialState) {

    fun error() {
        updateUIState {
            it.copy(screenState = DevProfileScreenState.Error)
        }
    }

    fun success(){
        updateUIState { it.copy(screenState =  DevProfileScreenState.Success) }
    }

    fun refresh(refresh : Boolean){
        updateUIState { it.copy(refreshing = refresh) }
    }

    fun load(){
        updateUIState { it.copy(screenState = DevProfileScreenState.Loading) }
    }



}