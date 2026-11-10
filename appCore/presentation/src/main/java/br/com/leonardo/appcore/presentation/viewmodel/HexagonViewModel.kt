package br.com.leonardo.appcore.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.appcore.presentation.action.HandleAction
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.data.data.HexagonData
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.appcore.presentation.data.uidata.HexagonUIData
import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState
import kotlinx.coroutines.launch

/**
 * Base abstract ViewModel for Hexagon architecture providing state and action execution capabilities.
 *
 * @param S The UI state type.
 * @param D The data state container type extending [HexagonData].
 * @param UI The refreshable UI state type extending [HexagonUIState].
 * @param UID The UI data container type extending [HexagonUIData].
 */
abstract class HexagonViewModel<S : HexagonState, D : HexagonData<S>, UI : HexagonUIState, UID : HexagonUIData<UI>> :
    ViewModel(),
    HandleAction {
    /** Data container state holding business data and states. */
    abstract val data: D

    /** UI data container holding display states and UI models. */
    abstract val uiData: UID

    private var observer: HandleAction? = null

    /**
     * Executes and forwards the given [HexagonAction] to the registered observer.
     *
     * @param action The [HexagonAction] to execute.
     */
    fun executeAction(action: HexagonAction) {
        observer?.handleAction(action)
    }

    /**
     * Registers an observer for handling emitted actions.
     *
     * @param observer The [HandleAction] observer.
     */
    fun setObserver(observer: HandleAction) {
        this.observer = observer
    }

    @Suppress("EmptyFunctionBlock")
    override fun handleAction(action: HexagonAction) {
    }

    /**
     * Executes a suspending block within `viewModelScope` with error handling.
     *
     * @param block The suspending task to execute.
     * @param onError Callback invoked if an exception is caught.
     */
    @Suppress("TooGenericExceptionCaught")
    fun executeBlock(
        block: suspend () -> Unit,
        onError: (Throwable) -> Unit = {},
    ) {
        viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }

    /**
     * Executes a suspending block returning a [Result] within `viewModelScope`.
     *
     * @param MO The success model type.
     * @param block Suspending lambda returning a [Result].
     * @param onSuccess Callback invoked on success with result value.
     * @param onError Callback invoked on failure with exception.
     */
    fun <MO> executeBlock(
        block: suspend () -> Result<MO>,
        onSuccess: (MO) -> Unit = {},
        onError: (Throwable) -> Unit = {},
    ) {
        viewModelScope.launch {
            block.invoke().fold(
                onSuccess = { data -> onSuccess(data) },
                onFailure = { exception -> onError(exception) },
            )
        }
    }
}
