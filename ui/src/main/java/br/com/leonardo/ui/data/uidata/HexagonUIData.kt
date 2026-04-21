package br.com.leonardo.ui.data.uidata

import br.com.leonardo.ui.data.uistate.HexagonUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class HexagonUIData <US : HexagonUIState>(initialValue: US) {

    private val privateState = MutableStateFlow(initialValue)
    val uiState = privateState.asStateFlow()

    fun updateUIState(transform: (currentState: US) -> US) {
        privateState.update { currentState ->
            transform(currentState)
        }
    }

    fun getState(): US = privateState.value

}