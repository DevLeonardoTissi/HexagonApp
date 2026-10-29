package br.com.leonardo.ui.data.data

import br.com.leonardo.ui.data.state.HexagonState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class HexagonData<S : HexagonState>(initialValue: S) {

    val state: StateFlow<S>
        field = MutableStateFlow(initialValue)

    fun updateState(transform: (currentState: S) -> S) {
        state.update { currentState ->
            transform(currentState)
        }
    }

    fun getState(): S = state.value

}