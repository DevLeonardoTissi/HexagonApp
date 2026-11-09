package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.userPhotoPicker

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class UserPhotoPickerSection :
    HexagonSection<PersonalProfileFormState, PersonalProfileFormUIState, UserPhotoPickerSectionRender>(
        view = UserPhotoPickerView(),
        mapper = UserPhotoPickerSectionMapper(),
    )
