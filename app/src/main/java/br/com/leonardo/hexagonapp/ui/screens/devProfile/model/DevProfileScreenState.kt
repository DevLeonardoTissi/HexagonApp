package br.com.leonardo.hexagonapp.ui.screens.devProfile.model

sealed class DevProfileScreenState {
    data object Loading : DevProfileScreenState()
    data object Error : DevProfileScreenState()
    data object Success : DevProfileScreenState()
}