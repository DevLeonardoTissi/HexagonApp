package br.com.leonardo.hexagonapp.ui.screens.form

import br.com.leonardo.hexagonapp.utils.extensions.long.toBrazilianDateFormat
import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.data.data.HexagonData

class PersonalProfileFormData(initialState: PersonalProfileFormState) :
    HexagonData<PersonalProfileFormState>(initialValue = initialState) {

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
                dateOfBirthPresentation = user.dateOfBirth.toBrazilianDateFormat()
            )
        }
    }

    fun getUserInfo(): PersonalProfile = PersonalProfile(
        id = state.value.id,
        name = state.value.name,
        cpf = state.value.cpf,
        city = state.value.city,
        photo = state.value.photo,
        dateOfBirth = state.value.dateOfBirth,
        active = state.value.active
    )

    fun updateName(name: String) {
        updateState { it.copy(name = name) }
    }

    fun getUserName(): String = state.value.name

    fun updateCpf(cpf: String) {
        updateState { it.copy(cpf = cpf) }
    }

    fun getUserCpf(): String = state.value.cpf

    fun updateCity(city: String) {
        updateState { it.copy(city = city) }
    }

    fun getUserCity(): String = state.value.city

    fun updateDateOfBirth(dateOfBirth: Long) {
        updateState {
            it.copy(
                dateOfBirth = dateOfBirth,
                dateOfBirthPresentation = dateOfBirth.toBrazilianDateFormat()
            )
        }
    }

    fun getUserDateOfBirth(): Long = state.value.dateOfBirth

    fun updatePhoto(photo: String?) {
        updateState { it.copy(photo = photo) }
    }

    fun updateActive(active: Boolean) {
        updateState { it.copy(active = active) }
    }


}