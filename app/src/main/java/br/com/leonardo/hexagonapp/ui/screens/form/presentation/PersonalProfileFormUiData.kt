package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import br.com.leonardo.appcore.presentation.data.uidata.HexagonUIData

/** UI Data holder for [PersonalProfileFormUIState]. */
class PersonalProfileFormUiData(
    initialState: PersonalProfileFormUIState,
) : HexagonUIData<PersonalProfileFormUIState>(initialValue = initialState) {
    /** Updates date picker dialog visibility. */
    fun updateDatePickerVisibility(show: Boolean) {
        updateUIState { it.copy(showDatePickerDialog = show) }
    }

    /** Updates confirm dialog visibility. */
    fun updateConfirmDialogVisibility(show: Boolean) {
        updateUIState { it.copy(showConfirmDialog = show) }
    }

    /** Sets validation error flag for name field. */
    fun setFieldNameError(isError: Boolean) {
        updateUIState { it.copy(fieldNameError = isError) }
    }

    /** Sets validation error flag for CPF field. */
    fun setFieldCPFError(isError: Boolean) {
        updateUIState { it.copy(fieldCPFError = isError) }
    }

    /** Sets validation error flag for city field. */
    fun setFieldCityError(isError: Boolean) {
        updateUIState { it.copy(fieldCityError = isError) }
    }

    /** Sets validation error flag for birth date field. */
    fun setFieldDateOfBirthError(isError: Boolean) {
        updateUIState { it.copy(fieldDateOfBirthError = isError) }
    }

    /** Updates confirm button enabled state. */
    fun setConfirmButtonEnable(enable: Boolean) {
        updateUIState { it.copy(confirmButtonEnable = enable) }
    }
}
