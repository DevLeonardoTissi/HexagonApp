package br.com.leonardo.hexagonapp.ui.screens.form.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.hexagonapp.ui.screens.form.sections.confirmButton.ConfirmButtonSection
import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.content.provider.HexagonContentProvider

class PersonalProfileFormScreenBottomContentProvider: HexagonContentProvider<PersonalProfileFormState, PersonalProfileFormUIState> {

    override fun getContent(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState
    ): List<HexagonContent> = listOf(
        ConfirmButtonSection()
    )
}