package br.com.leonardo.hexagonapp.ui.screens.form

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.hexagonapp.utils.extensions.toBrazilianDateFormat
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
    private val id: String? = savedStateHandle["profileId"]

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
                    _uiState.value =
                        _uiState.value.copy(dateOfBirth = dateOfBirth.toBrazilianDateFormat())
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
                },
                onFieldNameErrorChanged = {
                    _uiState.value = _uiState.value.copy(fieldNameError = it)
                },
                onFieldCPFErrorChanged = {
                    _uiState.value = _uiState.value.copy(fieldCPFError = it)
                },
                onFieldCityErrorChanged = {
                    _uiState.value = _uiState.value.copy(fieldCityError = it)
                },
                onFieldDateOfBirthErrorChanged = {
                    _uiState.value = _uiState.value.copy(fieldDateOfBirthError = it)
                },
                checkFields = {
                    if (checkFields()) {
                        _uiState.value.onShowConfirmDialog(true)
                    }
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


    private fun checkFields(): Boolean {
        val fieldsToCheck = listOf(
            Pair(uiState.value.name.isBlank()) { isError: Boolean ->
                _uiState.value.onFieldNameErrorChanged(
                    isError
                )
            },
            Pair(uiState.value.cpf.isBlank()) { isError: Boolean ->
                _uiState.value.onFieldCPFErrorChanged(
                    isError
                )
            },
            Pair(uiState.value.city.isBlank()) { isError: Boolean ->
                _uiState.value.onFieldCityErrorChanged(
                    isError
                )
            },
            Pair(uiState.value.dateOfBirth.isBlank()) { isError: Boolean ->
                _uiState.value.onFieldDateOfBirthErrorChanged(
                    isError
                )
            }
        )

        var allOk = true

        fieldsToCheck.forEach { (isBlank, setError) ->
            if (isBlank) {
                setError(true)
                allOk = false
            } else {
                setError(false)
            }
        }
        return allOk
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