package br.com.leonardo.hexagonapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetActivesProfilesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getActivesProfilesUseCase: GetActivesProfilesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun remove(profile: PersonalProfile) {
        viewModelScope.launch {
            deleteProfileUseCase(profile)
        }
    }

    init {
        viewModelScope.launch {
            getActivesProfilesUseCase().collect { activesList ->
                _uiState.update { currentState ->
                    currentState.copy(activesList = activesList)
                }
            }
        }
    }
}