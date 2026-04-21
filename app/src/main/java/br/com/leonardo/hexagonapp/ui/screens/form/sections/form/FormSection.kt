package br.com.leonardo.hexagonapp.ui.screens.form.sections.form

import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.ui.content.layout.section.HexagonSection

class FormSection: HexagonSection<PersonalProfileFormState, PersonalProfileFormUIState, FormSectionRender>(
    view = FormSectionView(),
    mapper = FormSectionMapper()
)