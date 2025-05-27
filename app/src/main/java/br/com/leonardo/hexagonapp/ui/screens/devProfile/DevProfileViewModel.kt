package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.utils.DevUiProfileState
import br.com.leonardo.webClient.usecase.GetUserProfileInfoUseCase
import br.com.leonardo.webClient.usecase.GetUserRepositoriesInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DevProfileViewModel(
    private val getUserProfileInfoUseCase: GetUserProfileInfoUseCase,
    private val getUserRepositoriesInfoUseCase: GetUserRepositoriesInfoUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        DevProfileUiState(
            state = DevUiProfileState.Loading,
            onLoadUserInfo = ::loadUserInfo
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        loadUserInfo()
    }


    private fun loadUserInfo() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(state = DevUiProfileState.Loading)

            kotlin.runCatching {
                _uiState.value.copy(
                    userProfile = getUserProfileInfoUseCase(),
                    repositories = getUserRepositoriesInfoUseCase(),
                    state = DevUiProfileState.Success
                )

            }.onSuccess { newState ->
                _uiState.value = newState
            }.onFailure {
                _uiState.value = _uiState.value.copy(
                    state = DevUiProfileState.Error
                )
            }
        }
    }
}