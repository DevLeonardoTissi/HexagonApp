package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import br.com.leonardo.appcore.presentation.data.data.HexagonData
import br.com.leonardo.appcore.presentation.utils.extensions.toBrazilianDateFormat
import br.com.leonardo.localData.model.PersonalProfile

/** Data holder for [PersonalProfileFormState]. */
@Suppress("detekt.TooManyFunctions")
class PersonalProfileFormData(
    initialState: PersonalProfileFormState,
) : HexagonData<PersonalProfileFormState>(initialValue = initialState) {
    /** Population method for editing existing user profile. */
    fun updateUserProfile(user: PersonalProfile) {
        updateState {
            it.copy(
                id = user.id,
                name = user.name,
                cpf = user.cpf.filter { cpf -> cpf.isDigit() },
                city = user.city,
                photo = user.photo,
                dateOfBirth = user.dateOfBirth,
                active = user.active,
                dateOfBirthPresentation = user.dateOfBirth.toBrazilianDateFormat(),
            )
        }
    }

    /** Constructs [PersonalProfile] entity from current form state. */
    fun getUserInfo(): PersonalProfile =
        PersonalProfile(
            id = state.value.id,
            name = state.value.name,
            cpf = state.value.cpf,
            city = state.value.city,
            photo = state.value.photo,
            dateOfBirth = state.value.dateOfBirth,
            active = state.value.active,
        )

    /** Updates name field in state. */
    fun updateName(name: String) {
        updateState { it.copy(name = name) }
    }

    /** Returns current name field value. */
    fun getUserName(): String = state.value.name

    /** Updates CPF field in state. */
    fun updateCpf(cpf: String) {
        updateState { it.copy(cpf = cpf) }
    }

    /** Returns current CPF field value. */
    fun getUserCpf(): String = state.value.cpf

    /** Updates city field in state. */
    fun updateCity(city: String) {
        updateState { it.copy(city = city) }
    }

    /** Returns current city field value. */
    fun getUserCity(): String = state.value.city

    /** Updates date of birth field in state. */
    fun updateDateOfBirth(dateOfBirth: Long) {
        updateState {
            it.copy(
                dateOfBirth = dateOfBirth,
                dateOfBirthPresentation = dateOfBirth.toBrazilianDateFormat(),
            )
        }
    }

    /** Returns current date of birth value in milliseconds. */
    fun getUserDateOfBirth(): Long = state.value.dateOfBirth

    /** Updates photo URL in state. */
    fun updatePhoto(photo: String?) {
        updateState { it.copy(photo = photo) }
    }

    /** Updates active toggle state. */
    fun updateActive(active: Boolean) {
        updateState { it.copy(active = active) }
    }
}
