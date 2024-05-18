package br.com.leonardo.hexagonapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.repository.PersonalProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val repository: PersonalProfileRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun remove(profile : PersonalProfile){
        viewModelScope.launch {
            repository.remove(profile)
        }
    }

    init {
        viewModelScope.launch {
            repository.getActives().collect { activesList ->
                _uiState.update { currentState ->
                    currentState.copy(activesList = activesList)
                }
            }
        }
    }
}