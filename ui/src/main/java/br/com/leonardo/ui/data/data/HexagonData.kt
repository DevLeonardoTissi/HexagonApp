package br.com.leonardo.ui.data.data

import br.com.leonardo.ui.data.state.HexagonState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class HexagonData<S : HexagonState>(initialValue: S) {

    private val privateState = MutableStateFlow(initialValue)
    val state = privateState.asStateFlow()

    fun updateState(transform: (currentState: S) -> S) {
        privateState.update { currentState ->
            transform(currentState)
        }
    }

}