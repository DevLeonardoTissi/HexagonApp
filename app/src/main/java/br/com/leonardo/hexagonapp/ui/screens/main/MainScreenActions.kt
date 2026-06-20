package br.com.leonardo.hexagonapp.ui.screens.main

import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.navigator.Route

sealed class MainScreenActions : HexagonAction() {
    class ChangeDarkMode(val isDarkMode: Boolean) : MainScreenActions()

    class ChangeNotificationsSettings(val showNotifications: Boolean) : MainScreenActions()

    class DisplayedBottomSheet(val displayed: Boolean) : MainScreenActions()
    class CurrencyRouteChanged(val route: Route): MainScreenActions()
}