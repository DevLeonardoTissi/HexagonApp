package br.com.leonardo.hexagonapp.ui.screens.inactive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InactiveProfilesViewModel(private val repository: PersonalProfileRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(InactiveProfilesUiState())
    val uiState = _uiState.asStateFlow()

    fun remove(profile: PersonalProfile) {
        viewModelScope.launch {
            repository.remove(profile)
        }
    }

    init {
        viewModelScope.launch {
            repository.getInactive().collect { inactiveList ->
                _uiState.update { currentState ->
                    currentState.copy(inactiveList = inactiveList)
                }
            }
        }
    }
}