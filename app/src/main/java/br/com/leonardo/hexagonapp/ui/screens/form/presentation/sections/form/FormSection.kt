package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.form

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class FormSection :
    HexagonSection<PersonalProfileFormState, PersonalProfileFormUIState, FormSectionRender>(
        view = FormSectionView(),
        mapper = FormSectionMapper(),
    )
