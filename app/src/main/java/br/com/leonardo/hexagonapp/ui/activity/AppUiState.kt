package br.com.leonardo.hexagonapp.ui.activity


import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import br.com.leonardo.hexagonapp.utils.AppRoute

data class AppUiState(
    val isDarkMode: Boolean = false,
    val onDarkModeChange: (Boolean) -> Unit = {},
    val showBottomSheetDialogInfoAndConfig: Boolean = false,
    val changeVisibilityBottomSheetDialogInfoAndConfig: (Boolean) -> Unit = {},
    var drawerState: DrawerState = DrawerState(DrawerValue.Closed),
    var showAddFloatingActionButton: Boolean = true,
    var currentRoute: AppRoute = AppRoute.Home,
    val onCurrentRouteChange: (String) -> Unit = {},
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

    fun isHomeScreen():Boolean = currentRoute == AppRoute.Home
    fun isFormScreen():Boolean = currentRoute == AppRoute.Form
    fun isInactiveScreen():Boolean = currentRoute == AppRoute.Inactive
    fun isDevProfileScreen():Boolean = currentRoute == AppRoute.DevProfile
}