package br.com.leonardo.hexagonapp.ui.screens.form.sections.confirmButton

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.ui.content.layout.section.HexagonSection

class ConfirmButtonSection: HexagonSection<PersonalProfileFormState, PersonalProfileFormUIState, ConfirmButtonSectionRender>(
    view = ConfirmButtonSectionView(),
    mapper = ConfirmButtonSectionMapper()
)