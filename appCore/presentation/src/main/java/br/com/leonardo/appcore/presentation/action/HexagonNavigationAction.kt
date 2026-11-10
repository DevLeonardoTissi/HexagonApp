package br.com.leonardo.appcore.presentation.action

import br.com.leonardo.appcore.presentation.navigator.Route

/**
 * Sealed class representing navigation actions triggered by view models or screens.
 */
sealed class HexagonNavigationAction : HexagonAction() {
    /**
     * Action representing a request to navigate back in the navigation stack.
     */
    object GoBack : HexagonNavigationAction()

    /**
     * Action representing a request to navigate to a specific [Route].
     *
     * @property route The target [Route] to navigate to.
     */
    class NavigateTo(
        val route: Route,
    ) : HexagonNavigationAction()
}
