package br.com.leonardo.hexagonapp.ui.screens.form

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.leonardo.hexagonapp.utils.extensions.long.toBrazilianDateFormat
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.usecase.GetProfileByIdUseCase
import br.com.leonardo.localData.usecase.InsertProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonalProfileFormViewModel(
    private val insertProfileUseCase: InsertProfileUseCase,
    private val getProfileByIdUseCase: GetProfileByIdUseCase,
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
                        _uiState.value.copy(
                            dateOfBirth = dateOfBirth,
                            dateOfBirthPresentation = dateOfBirth.toBrazilianDateFormat()
                        )
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
            with(getProfileByIdUseCase(id = id)) {
                _uiState.value = _uiState.value.copy(
                    id = this.id,
                    name = name,
                    cpf = cpf.filter { it.isDigit() },
                    city = city,
                    dateOfBirth = dateOfBirth,
                    dateOfBirthPresentation = dateOfBirth.toBrazilianDateFormat(),
                    photo = photo,
                    active = active
                )
            }
        }
    }

    private fun invalidCpf(cpf: String): Boolean = cpf.isBlank() || cpf.length != 11

    fun formatCpf(cpf: String): String {
        return cpf.replace(Regex("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"), "$1.$2.$3-$4")
    }

    private fun checkFields(): Boolean {
        val fieldsToCheck = listOf(
            Pair(uiState.value.name.isBlank()) { isError: Boolean ->
                _uiState.value.onFieldNameErrorChanged(
                    isError
                )
            },
            Pair(invalidCpf(uiState.value.cpf)) { isError: Boolean ->
                _uiState.value.onFieldCPFErrorChanged(
                    isError
                )
            },
            Pair(uiState.value.city.isBlank()) { isError: Boolean ->
                _uiState.value.onFieldCityErrorChanged(
                    isError
                )
            },
            Pair(uiState.value.dateOfBirth == 0L) { isError: Boolean ->
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
            insertProfileUseCase(
                PersonalProfile(
                    id = uiState.value.id,
                    name = uiState.value.name,
                    cpf = formatCpf(uiState.value.cpf),
                    city = uiState.value.city,
                    photo = uiState.value.photo,
                    dateOfBirth = uiState.value.dateOfBirth,
                    active = uiState.value.active
                )
            )
        }
    }
}