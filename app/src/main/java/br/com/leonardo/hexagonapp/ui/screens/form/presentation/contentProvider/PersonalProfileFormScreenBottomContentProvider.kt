package br.com.leonardo.hexagonapp.ui.screens.form.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonContent
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.confirmButton.ConfirmButtonSection

class PersonalProfileFormScreenBottomContentProvider :
    HexagonContentProvider<PersonalProfileFormState, PersonalProfileFormUIState> {
    override fun getContent(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState,
    ): List<HexagonContent> =
        listOf(
            ConfirmButtonSection(),
        )
}
