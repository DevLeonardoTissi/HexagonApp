package br.com.leonardo.hexagonapp.ui.screens.form.sections.userPhotoPicker

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormState
import br.com.leonardo.hexagonapp.ui.screens.form.PersonalProfileFormUIState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class UserPhotoPickerSectionMapper :
    HexagonSectionMapper<PersonalProfileFormState, PersonalProfileFormUIState, UserPhotoPickerSectionRender> {

    @Composable
    override fun map(
        state: PersonalProfileFormState,
        uiState: PersonalProfileFormUIState
    ) = with(state) {
        UserPhotoPickerSectionRender(photoURI = photo)
    }
}