package br.com.leonardo.hexagonapp.ui.activity

data class AppUiState(
    val isDarkMode: Boolean = false,
    val onDarkModeChange: (Boolean) -> Unit = {},
    val showBottomSheetDialogInfoAndConfig: Boolean = false,
    val onShowBottomSheetDialogInfoAndConfig : (Boolean) -> Unit = {},


) {
}