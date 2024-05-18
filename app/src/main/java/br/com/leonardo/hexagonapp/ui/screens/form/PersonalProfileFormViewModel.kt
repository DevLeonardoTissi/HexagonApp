package br.com.leonardo.hexagonapp.ui.screens.form

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.navigation.profileIdArgument
import br.com.leonardo.hexagonapp.repository.PersonalProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonalProfileFormViewModel(
    private val repository: PersonalProfileRepository,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _uiState = MutableStateFlow(PersonalProfileFormUiState())
    val uiState = _uiState.asStateFlow()
    private val id: String? = savedStateHandle[profileIdArgument]

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onNameChanged = { name ->
                    _uiState.value = _uiState.value.copy(name = name)
                },
                onCpfChanged = { cpf ->
                    _uiState.value = _uiState.value.copy(cpf = cpf)
                },
                onCityChanged = { city ->
                    _uiState.value = _uiState.value.copy(city = city)
                },
                onDateOfBirthChanged = { dateOfBirth ->
                    _uiState.value = _uiState.value.copy(dateOfBirth = dateOfBirth)
                },
                onPhotoChanged = { photo ->
                    _uiState.value = _uiState.value.copy(photo = photo)
                },
                onActiveChanged = { active ->
                    _uiState.value = _uiState.value.copy(active = active)
                },
                onSave = {
                    insert()
                },
                onShowDatePickerDialog = {
                    _uiState.value = _uiState.value.copy(showDatePickerDialog = it)
                },
                onShowConfirmDialog = {
                    _uiState.value = _uiState.value.copy(showConfirmDialog = it)
                }
            )
        }

        id?.let {
            searchById(it)
        }
    }

    private fun searchById(id: String) {
        viewModelScope.launch {
            val personalProfile = repository.getById(id = id)
            _uiState.value = _uiState.value.copy(
                id = personalProfile.id,
                name = personalProfile.name,
                cpf = personalProfile.cpf,
                city = personalProfile.city,
                dateOfBirth = personalProfile.dateOfBirth,
                photo = personalProfile.photo,
                active = personalProfile.active
            )
        }
    }

    private fun insert() {
        viewModelScope.launch {
            repository.insert(
                PersonalProfile(
                    id = uiState.value.id,
                    name = uiState.value.name,
                    cpf = uiState.value.cpf,
                    city = uiState.value.city,
                    photo = uiState.value.photo,
                    dateOfBirth = uiState.value.dateOfBirth,
                    active = uiState.value.active
                )
            )
        }
    }
}