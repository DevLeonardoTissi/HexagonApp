package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.confirmButton

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class ConfirmButtonSection :
    HexagonSection<PersonalProfileFormState, PersonalProfileFormUIState, ConfirmButtonSectionRender>(
        view = ConfirmButtonSectionView(),
        mapper = ConfirmButtonSectionMapper(),
    )
