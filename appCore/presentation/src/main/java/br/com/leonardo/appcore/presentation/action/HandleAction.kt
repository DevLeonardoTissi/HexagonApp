package br.com.leonardo.appcore.presentation.action

/**
 * Handles the action
 *
 */
interface HandleAction {
    /**
     * Handles the action
     *
     * @param action
     */
    fun handleAction(action: HexagonAction)
}
