package br.com.leonardo.ui.action

import br.com.leonardo.ui.navigator.Route

/**
 * Hexagon navigation action
 * Sealed hierarchy — all subtypes are known at compile time, ideal for exhaustive `when`.
 *
 * @constructor Creates a new HexagonNavigationAction
 */
sealed class HexagonNavigationAction : HexagonAction() {

    /**
     * Go back
     * Singleton object — a single shared instance.
     *
     * @constructor Creates a new GoBack
     */
    object GoBack : HexagonNavigationAction()

    /**
     * Navigate to
     *
     * @constructor Creates a new NavigateTo
     * @property route
     */
    class NavigateTo(val route: Route) : HexagonNavigationAction()

}