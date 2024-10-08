package br.com.leonardo.hexagonapp.ui.screens.form

import java.util.UUID

data class PersonalProfileFormUiState(
    var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var cpf: String = "",
    var city: String = "",
    var dateOfBirth: String = "",
    var photo: String? = "",
    var active: Boolean = true,
    val fieldNameError: Boolean = false,
    val fieldCPFError: Boolean = false,
    val fieldCityError: Boolean = false,
    val fieldDateOfBirthError: Boolean = false,
    val onFieldNameErrorChanged: (Boolean) -> Unit = {},
    val onFieldCPFErrorChanged: (Boolean) -> Unit = {},
    val onFieldCityErrorChanged: (Boolean) -> Unit = {},
    val onFieldDateOfBirthErrorChanged: (Boolean) -> Unit = {},
    val onNameChanged: (String) -> Unit = {},
    val onCpfChanged: (String) -> Unit = {},
    val onCityChanged: (String) -> Unit = {},
    val onDateOfBirthChanged: (Long) -> Unit = {},
    val onPhotoChanged: (String) -> Unit = {},
    val onActiveChanged: (Boolean) -> Unit = {},
    val onSave: () -> Unit = {},
    var showDatePickerDialog: Boolean = false,
    val onShowDatePickerDialog: (Boolean) -> Unit = {},
    var showConfirmDialog: Boolean = false,
    val onShowConfirmDialog: (Boolean) -> Unit = {},
    val checkFields: () -> Unit = {}
)