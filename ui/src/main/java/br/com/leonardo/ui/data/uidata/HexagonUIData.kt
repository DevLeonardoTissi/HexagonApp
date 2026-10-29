package br.com.leonardo.ui.data.uidata

import br.com.leonardo.ui.data.uistate.HexagonUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class HexagonUIData<US : HexagonUIState>(initialValue: US) {

    val uiState: StateFlow<US>
        field = MutableStateFlow(initialValue)

    fun updateUIState(transform: (currentState: US) -> US) {
        uiState.update { currentState ->
            transform(currentState)
        }
    }

    fun getState(): US = uiState.value

}