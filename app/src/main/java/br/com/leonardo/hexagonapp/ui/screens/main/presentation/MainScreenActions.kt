package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.navigator.Route

/** Actions emitted from root main container UI. */
sealed class MainScreenActions : HexagonAction() {
    /** Action to change dark mode preference. */
    class ChangeDarkMode(
        val isDarkMode: Boolean,
    ) : MainScreenActions()

    /** Action to change notifications preference. */
    class ChangeNotificationsSettings(
        val showNotifications: Boolean,
    ) : MainScreenActions()

    /** Action to toggle configuration bottom sheet visibility. */
    class DisplayedBottomSheet(
        val displayed: Boolean,
    ) : MainScreenActions()

    /** Action when active navigation route changes. */
    class CurrencyRouteChanged(
        val route: Route,
    ) : MainScreenActions()
}
