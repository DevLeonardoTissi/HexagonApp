package br.com.leonardo.ui.navigator

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.SnapshotStateList
import br.com.leonardo.ui.action.HexagonNavigationAction
import kotlinx.coroutines.flow.Flow

/**
 * Hexagon navigator
 *
 * @constructor Creates a new HexagonNavigator
 * @property startDestination the start destination
 */
class HexagonNavigator(val startDestination: Route) {
    val backstack: SnapshotStateList<Route> = mutableStateListOf(startDestination)
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
     * Handles the navigator action
     *
     * @param action
     */
    fun handleNavigatorAction(action: HexagonNavigationAction) {
        when (action) {
            is HexagonNavigationAction.NavigateTo -> navigateTo(action.route)
            is HexagonNavigationAction.GoBack -> goBack()
        }
    }

}
