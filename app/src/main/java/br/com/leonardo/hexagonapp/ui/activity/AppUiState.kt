package br.com.leonardo.hexagonapp.ui.activity

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import br.com.leonardo.hexagonapp.navigation.devProfileRoute
import br.com.leonardo.hexagonapp.navigation.formRoute
import br.com.leonardo.hexagonapp.navigation.homeRoute
import br.com.leonardo.hexagonapp.navigation.inactiveRoute

data class AppUiState(
    val isDarkMode: Boolean = false,
    val onDarkModeChange: (Boolean) -> Unit = {},
    val showBottomSheetDialogInfoAndConfig: Boolean = false,
    val changeVisibilityBottomSheetDialogInfoAndConfig: (Boolean) -> Unit = {},
    var drawerState: DrawerState = DrawerState(DrawerValue.Closed),
    var showAddFloatingActionButton: Boolean = true,
    var currentRoute: String = homeRoute,
    val onCurrentRouteChange: (String) -> Unit = {},
    val isHomeScreen: Boolean = currentRoute == homeRoute,
    val isFormScreen: Boolean = currentRoute == formRoute,
    val isDevProfileScreen: Boolean = currentRoute == devProfileRoute,
    val isInactiveScreen: Boolean = currentRoute == inactiveRoute,
) {
    suspend fun updateDrawer() {
        if (drawerState.isClosed) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }

}