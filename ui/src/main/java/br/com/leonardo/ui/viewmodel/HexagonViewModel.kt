package br.com.leonardo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.ui.action.HandleAction
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.data.data.HexagonData
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uidata.HexagonUIData
import br.com.leonardo.ui.data.uistate.HexagonUIState
import br.com.leonardo.ui.navigator.HexagonNavigator
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class HexagonViewModel< S : HexagonState, D : HexagonData<S>, UI : HexagonUIState, UID : HexagonUIData<UI>> :
    ViewModel(), HandleAction, KoinComponent {

    abstract val data: D
    abstract val uiData: UID

    private var observer: HandleAction? = null

    fun executeAction(action: HexagonAction) {
        observer?.handleAction(action)
    }

    fun setObserver(observer: HandleAction) {
        this.observer = observer
    }

    override fun handleAction(action: HexagonAction) {
    }


    fun executeBlock(block: suspend () -> Unit, onError: (Throwable) -> Unit = {}) {
        viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }

    fun <MO> executeBlock(
        block: suspend () -> Result<MO>,
        onSuccess: (MO) -> Unit = {},
        onError: (Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            block.invoke().fold(
                onSuccess = { data -> onSuccess(data) },
                onFailure = { exception -> onError(exception) }
            )
        }
    }
}