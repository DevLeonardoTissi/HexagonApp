package br.com.leonardo.appcore.presentation.navigator

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.SnapshotStateList
import br.com.leonardo.appcore.presentation.action.HexagonNavigationAction
import kotlinx.coroutines.flow.Flow

/**
 * Navigator handling navigation stacks and navigation actions for Hexagon screens.
 *
 * @property startDestination The initial [Route] destination.
 */
class HexagonNavigator(
    val startDestination: Route,
) {
    /** Mutable snapshot state list representing the current navigation backstack. */
    val backstack: SnapshotStateList<Route> = mutableStateListOf(startDestination)

    /** Flow emitting the current active [Route] at the top of the backstack. */
    val currentRouteFlow: Flow<Route?> = snapshotFlow { backstack.lastOrNull() }

    private fun navigateTo(destination: Route) {
        if (destination == startDestination) {
            backstack.clear()
        }
        backstack.add(destination)
    }

    private fun goBack() {
        backstack.removeLastOrNull()
    }

    /**
     * Handles navigation actions (e.g., [HexagonNavigationAction.NavigateTo] or [HexagonNavigationAction.GoBack]).
     *
     * @param action The [HexagonNavigationAction] to handle.
     */
    fun handleNavigatorAction(action: HexagonNavigationAction) {
        when (action) {
            is HexagonNavigationAction.NavigateTo -> navigateTo(action.route)
            is HexagonNavigationAction.GoBack -> goBack()
        }
    }
}
