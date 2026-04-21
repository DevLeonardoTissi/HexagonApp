package br.com.leonardo.hexagonapp.ui.screens.form

import br.com.leonardo.ui.data.uidata.HexagonUIData

class PersonalProfileFormUiData(initialState: PersonalProfileFormUIState) :
    HexagonUIData<PersonalProfileFormUIState>(initialValue = initialState) {

    fun updateDatePickerVisibility(show: Boolean) {
        updateUIState { it.copy(showDatePickerDialog = show) }
    }

    fun updateConfirmDialogVisibility(show: Boolean) {
        updateUIState { it.copy(showConfirmDialog = show) }
    }

    fun setFieldNameError(isError: Boolean) {
        updateUIState { it.copy(fieldNameError = isError) }
    }

    fun setFieldCPFError(isError: Boolean) {
        updateUIState { it.copy(fieldCPFError = isError) }
    }

    fun setFieldCityError(isError: Boolean) {
        updateUIState { it.copy(fieldCityError = isError) }
    }

    fun setFieldDateOfBirthError(isError: Boolean) {
        updateUIState { it.copy(fieldDateOfBirthError = isError) }
    }

    fun setConfirmButtonEnable(enable: Boolean) {
        updateUIState { it.copy(confirmButtonEnable = enable) }
    }


}