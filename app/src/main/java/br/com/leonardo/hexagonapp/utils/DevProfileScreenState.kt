package br.com.leonardo.hexagonapp.utils

sealed class DevProfileScreenState {
    data object Loading : DevProfileScreenState()
    data object Error : DevProfileScreenState()
    data object Success : DevProfileScreenState()
}