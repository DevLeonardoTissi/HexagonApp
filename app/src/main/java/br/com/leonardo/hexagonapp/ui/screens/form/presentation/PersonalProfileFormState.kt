package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import br.com.leonardo.appcore.domain.utils.extensions.EMPTY_STRING
import br.com.leonardo.appcore.presentation.data.state.HexagonState
import java.util.UUID

/** Data state holding form field values for personal profile registration. */
data class PersonalProfileFormState(
    var id: String = UUID.randomUUID().toString(),
    var name: String = String.EMPTY_STRING,
    var cpf: String = String.EMPTY_STRING,
    var city: String = String.EMPTY_STRING,
    var dateOfBirth: Long = 0,
    var dateOfBirthPresentation: String = String.EMPTY_STRING,
    var photo: String? = String.EMPTY_STRING,
    var active: Boolean = true,
) : HexagonState
