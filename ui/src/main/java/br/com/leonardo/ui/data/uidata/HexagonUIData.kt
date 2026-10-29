package br.com.leonardo.ui.data.uidata

import br.com.leonardo.ui.data.uistate.HexagonUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * Hexagon ui data
 *
 * @param US
 * @constructor
 * @param initialValue the initial value
 */
abstract class HexagonUIData<US : HexagonUIState>(initialValue: US) {

    val uiState: StateFlow<US>
        field = MutableStateFlow(initialValue)

    /**
     * Sets the ui state
     *
     * @param transform
     * @receiver
     */
    fun updateUIState(transform: (currentState: US) -> US) {
        uiState.update { currentState ->
            transform(currentState)
        }
    }

    /**
     * Returns the state
     *
     * @return the us
     */
    fun getState(): US = uiState.value

}