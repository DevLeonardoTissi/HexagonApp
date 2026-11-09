package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.confirmButton

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class ConfirmButtonSectionMapper :
    HexagonSectionMapper<PersonalProfileFormState, PersonalProfileFormUIState, ConfirmButtonSectionRender> {
    @Composable
    override fun map(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState,
    ) = with(uiState) {
        ConfirmButtonSectionRender(
            isEnable = true, // confirmButtonEnable
        )
    }
}
