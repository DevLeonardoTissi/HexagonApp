package br.com.leonardo.hexagonapp.ui.screens.main.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.navigator.Route

sealed class MainScreenActions : HexagonAction() {
    class ChangeDarkMode(
        val isDarkMode: Boolean,
    ) : MainScreenActions()

    class ChangeNotificationsSettings(
        val showNotifications: Boolean,
    ) : MainScreenActions()

    class DisplayedBottomSheet(
        val displayed: Boolean,
    ) : MainScreenActions()

    class CurrencyRouteChanged(
        val route: Route,
    ) : MainScreenActions()
}
