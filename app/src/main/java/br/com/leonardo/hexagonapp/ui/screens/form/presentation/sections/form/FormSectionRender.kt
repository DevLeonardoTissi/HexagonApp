package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.form

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender

data class FormSectionRender(
    var name: String,
    var cpf: String,
    var city: String,
    var dateOfBirth: Long,
    var dateOfBirthPresentation: String,
    var active: Boolean,
    var showDatePickerDialog: Boolean,
    var showConfirmDialog: Boolean,
    val fieldNameError: Boolean,
    val fieldCPFError: Boolean,
    val fieldCityError: Boolean,
    val fieldDateOfBirthError: Boolean,
) : HexagonSectionRender
