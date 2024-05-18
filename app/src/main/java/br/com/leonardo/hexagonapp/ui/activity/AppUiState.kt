package br.com.leonardo.hexagonapp.ui.activity

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import kotlinx.coroutines.CoroutineScope

data class AppUiState(
    val isDarkMode: Boolean = false,
    val onDarkModeChange: (Boolean) -> Unit = {},
    val showBottomSheetDialogInfoAndConfig: Boolean = false,
    val onShowBottomSheetDialogInfoAndConfig : (Boolean) -> Unit = {},
    var drawerState: DrawerState = DrawerState(DrawerValue.Closed),
    val updateDrawer :()->Unit = {}

){


}