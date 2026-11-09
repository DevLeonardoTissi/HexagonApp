package br.com.leonardo.hexagonapp.ui.screens.form.presentation.sections.userPhotoPicker

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.presentation.PersonalProfileFormUIState

class UserPhotoPickerSectionMapper :
    HexagonSectionMapper<PersonalProfileFormState, PersonalProfileFormUIState, UserPhotoPickerSectionRender> {
    @Composable
    override fun map(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState,
    ) = with(state) {
        UserPhotoPickerSectionRender(photoURI = photo)
    }
}
