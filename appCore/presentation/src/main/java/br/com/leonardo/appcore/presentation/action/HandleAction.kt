package br.com.leonardo.appcore.presentation.action

/**
 * Interface for handling UI actions emitted by screens or components.
 */
interface HandleAction {
    /**
     * Handles the given [HexagonAction].
     *
     * @param action The [HexagonAction] to handle.
     */
    fun handleAction(action: HexagonAction)
}
