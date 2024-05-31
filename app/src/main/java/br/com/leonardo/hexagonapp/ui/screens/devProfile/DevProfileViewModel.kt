package br.com.leonardo.hexagonapp.ui.screens.devProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.repository.GithubUserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DevProfileViewModel(private val githubUserRepository: GithubUserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(DevProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {

                _uiState.update { currentState ->
                    currentState.copy(
                        userProfile = githubUserRepository.getUserProfileInfo(),
                        loadingInfo = false
                    )

                }


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}