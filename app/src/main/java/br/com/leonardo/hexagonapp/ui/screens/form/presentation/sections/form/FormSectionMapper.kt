package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.form

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class FormSectionMapper :
    HexagonSectionMapper<PersonalProfileFormState, PersonalProfileFormUIState, FormSectionRender> {
    @Composable
    override fun map(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState,
    ): FormSectionRender =
        FormSectionRender(
            name = state.name,
            cpf = state.cpf,
            city = state.city,
            dateOfBirth = state.dateOfBirth,
            dateOfBirthPresentation = state.dateOfBirthPresentation,
            active = state.active,
            showDatePickerDialog = uiState.showDatePickerDialog,
            showConfirmDialog = uiState.showConfirmDialog,
            fieldNameError = uiState.fieldNameError,
            fieldCPFError = uiState.fieldCPFError,
            fieldCityError = uiState.fieldCityError,
            fieldDateOfBirthError = uiState.fieldDateOfBirthError,
        )
}
