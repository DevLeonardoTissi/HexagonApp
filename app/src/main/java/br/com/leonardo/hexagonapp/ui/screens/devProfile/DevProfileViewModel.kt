package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.repository.GithubUserRepository
import br.com.leonardo.hexagonapp.utils.DevUiProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DevProfileViewModel(private val githubUserRepository: GithubUserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(DevProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadUserInfo()
    }

    private fun updateUiState(newState: DevProfileUiState) {
        _uiState.value = newState
    }

    private fun loadUserInfo() {
        viewModelScope.launch {
            updateUiState(
                DevProfileUiState(
                    state = DevUiProfileState.Loading,
                    onLoadUserInfo = { loadUserInfo() }
                ))

            try {
                val userProfile = githubUserRepository.getUserProfileInfo()
                val repositories = githubUserRepository.getUserRepositoriesInfo()

                updateUiState(
                    DevProfileUiState(
                        userProfile = userProfile,
                        repositories = repositories,
                        state = DevUiProfileState.Success,
                        onLoadUserInfo = { loadUserInfo() }
                    )
                )

            } catch (e: Exception) {
                updateUiState(
                    DevProfileUiState(
                        state = DevUiProfileState.Error,
                        onLoadUserInfo = { loadUserInfo() }
                    )
                )
            }
        }
    }
}