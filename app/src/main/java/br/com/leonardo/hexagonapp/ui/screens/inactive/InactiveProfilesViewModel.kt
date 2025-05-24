package br.com.leonardo.hexagonapp.ui.screens.inactive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.DeleteProfileUseCase
import br.com.leonardo.localData.usecase.GetInactivesProfilesUseCase
import br.com.leonardo.localData.usecase.UpdateProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InactiveProfilesViewModel(
    private val getInactivesProfilesUseCase: GetInactivesProfilesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(InactiveProfilesUiState())
    val uiState = _uiState.asStateFlow()

    fun remove(profile: PersonalProfile) {
        viewModelScope.launch {
            deleteProfileUseCase(profile)
        }
    }

    fun update(profile: PersonalProfile) {
        viewModelScope.launch {
            updateProfileUseCase(profile)
        }
    }

    init {
        viewModelScope.launch {
            getInactivesProfilesUseCase().collect { inactiveList ->
                _uiState.update { currentState ->
                    currentState.copy(inactiveList = inactiveList)
                }
            }
        }
    }
}