package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState

data class PersonalProfileFormUIState(
    var showDatePickerDialog: Boolean = false,
    var showConfirmDialog: Boolean = false,
    val fieldNameError: Boolean = false,
    val fieldCPFError: Boolean = false,
    val fieldCityError: Boolean = false,
    val fieldDateOfBirthError: Boolean = false,
    val confirmButtonEnable: Boolean = false,
) : HexagonUIState
