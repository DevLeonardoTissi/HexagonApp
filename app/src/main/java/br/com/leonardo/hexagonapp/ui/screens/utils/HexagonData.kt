package br.com.leonardo.hexagonapp.ui.screens.utils

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