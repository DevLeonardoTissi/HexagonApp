package br.com.leonardo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.ui.action.HandleAction
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.data.data.HexagonData
import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.ui.data.uidata.HexagonUIData
import br.com.leonardo.ui.data.uistate.HexagonUIState
import kotlinx.coroutines.launch

/**
 * Hexagon view model
 * Android [ViewModel] — survives configuration changes and exposes observable UI state.
 *
 * @param S
 * @param D
 * @param UI
 * @param UID
 * @constructor Creates a new HexagonViewModel
 */
abstract class HexagonViewModel< S : HexagonState, D : HexagonData<S>, UI : HexagonUIState, UID : HexagonUIData<UI>> :
    ViewModel(), HandleAction {

    abstract val data: D
    abstract val uiData: UID

    private var observer: HandleAction? = null

    /**
     * Handles the action
     *
     * @param action
     */
    fun executeAction(action: HexagonAction) {
        observer?.handleAction(action)
    }

    /**
     * Sets the observer
     *
     * @param observer
     */
    fun setObserver(observer: HandleAction) {
        this.observer = observer
    }

    override fun handleAction(action: HexagonAction) {
    }


    /**
     * Handles the block
     *
     * @param block
     * @receiver
     * @param onError the on error
     * @receiver
     */
    fun executeBlock(block: suspend () -> Unit, onError: (Throwable) -> Unit = {}) {
        viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }

    /**
     * Handles the block
     *
     * @param MO
     * @param block
     * @receiver
     * @param onSuccess the on success
     * @receiver
     * @param onError the on error
     * @receiver
     */
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
