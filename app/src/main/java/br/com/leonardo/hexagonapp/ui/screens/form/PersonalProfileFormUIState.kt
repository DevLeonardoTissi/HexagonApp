package br.com.leonardo.hexagonapp.ui.screens.form

import br.com.leonardo.ui.data.uistate.HexagonUIState

data class PersonalProfileFormUIState(
    var showDatePickerDialog: Boolean = false,
    var showConfirmDialog: Boolean = false,
    val fieldNameError: Boolean = false,
    val fieldCPFError: Boolean = false,
    val fieldCityError: Boolean = false,
    val fieldDateOfBirthError: Boolean = false,
    val confirmButtonEnable: Boolean = false
): HexagonUIState