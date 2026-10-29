package br.com.leonardo.ui.data.data

import br.com.leonardo.ui.data.state.HexagonState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * Hexagon data
 *
 * @param S
 * @constructor
 * @param initialValue the initial value
 */
abstract class HexagonData<S : HexagonState>(initialValue: S) {

    val state: StateFlow<S>
        field = MutableStateFlow(initialValue)

    /**
     * Sets the state
     *
     * @param transform
     * @receiver
     */
    fun updateState(transform: (currentState: S) -> S) {
        state.update { currentState ->
            transform(currentState)
        }
    }

    /**
     * Returns the state
     *
     * @return the s
     */
    fun getState(): S = state.value

}