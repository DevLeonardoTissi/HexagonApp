package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import br.com.leonardo.appcore.presentation.data.uistate.HexagonUIState

/** UI State flags holding dialog visibility and validation error indicators. */
data class PersonalProfileFormUIState(
    var showDatePickerDialog: Boolean = false,
    var showConfirmDialog: Boolean = false,
    val fieldNameError: Boolean = false,
    val fieldCPFError: Boolean = false,
    val fieldCityError: Boolean = false,
    val fieldDateOfBirthError: Boolean = false,
    val confirmButtonEnable: Boolean = false,
) : HexagonUIState
