package br.com.leonardo.appcore.presentation.action

/**
 * Interface defining action handlers for Activity-level operations.
 */
interface ActivityHandler {
    /**
     * Handles actions coming from feature screens (validates navigation or forwards locally).
     *
     * @param action The [HexagonAction] emitted by the screen.
     */
    fun handleScreenAction(action: HexagonAction)

    /**
     * Handles actions coming from the AppViewModel that only the Activity knows how to process.
     *
     * @param action The [HexagonAction] emitted by the AppViewModel.
     */
    fun handleAppViewModelAction(action: HexagonAction)
}
