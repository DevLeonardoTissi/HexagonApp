package br.com.leonardo.hexagonapp.ui.activity


import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import br.com.leonardo.hexagonapp.utils.AppRoute
import br.com.leonardo.webClient.utils.NetworkState

data class AppUiState(
    val isDarkMode: Boolean = false,
    val showNotifications:Boolean= false,
    val onDarkModeChange: (Boolean) -> Unit = {},
    val onShowNotificationsChange: (Boolean) -> Unit = {},
    val showBottomSheetDialogInfoAndConfig: Boolean = false,
    val changeVisibilityBottomSheetDialogInfoAndConfig: (Boolean) -> Unit = {},
    var drawerState: DrawerState = DrawerState(DrawerValue.Closed),
    var showAddFloatingActionButton: Boolean = true,
    var currentRoute: AppRoute = AppRoute.Home,
    val onCurrentRouteChange: (String) -> Unit = {},
    val networkStatus: NetworkState = NetworkState.Lost,
    val batteryIsLow: Boolean = false
) {
    suspend fun updateDrawer() {
        if (drawerState.isClosed) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }

    companion object {
        const val devProfileRoute = "DevProfileRoute"
        const val homeRoute = "HomeRoute"
        const val inactiveRoute = "InactiveRoute"
        const val formRoute = "FormRoute"
    }

    fun isHomeScreen(): Boolean = currentRoute == AppRoute.Home
    fun isFormScreen(): Boolean = currentRoute == AppRoute.Form
    fun isInactiveScreen(): Boolean = currentRoute == AppRoute.Inactive
    fun isDevProfileScreen(): Boolean = currentRoute == AppRoute.DevProfile
}