package br.com.leonardo.hexagonapp.utils

sealed class DevUiProfileState {
    data object Loading : DevUiProfileState()
    data object Error : DevUiProfileState()
    data object Success : DevUiProfileState()
}