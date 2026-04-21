package br.com.leonardo.hexagonapp.ui.screens.form.sections.confirmButton

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class ConfirmButtonSectionMapper :
    HexagonSectionMapper<PersonalProfileFormState, PersonalProfileFormUIState, ConfirmButtonSectionRender> {
    @Composable
    override fun map(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState
    ) = with(uiState) {
        ConfirmButtonSectionRender(
            isEnable = true // confirmButtonEnable
        )
    }
}