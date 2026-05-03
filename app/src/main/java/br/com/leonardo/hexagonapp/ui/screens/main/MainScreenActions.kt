package br.com.leonardo.hexagonapp.ui.screens.main

import androidx.navigation.NavOptions
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.navigator.Route

sealed class MainScreenActions : HexagonAction() {
    class ChangeDarkMode(val isDarkMode: Boolean) : MainScreenActions()

    class ChangeNotificationsSettings(val showNotifications: Boolean) : MainScreenActions()

    class DisplayedBottomSheet(val displayed: Boolean) : MainScreenActions()

    class CurrentRouteChanged(val route: String) : MainScreenActions()
    class NavigateToRoute(val route: Route, val navOptions: NavOptions? = null) :
        MainScreenActions()

    object NavigateBack : MainScreenActions()
    object NavigatePop : MainScreenActions()

}