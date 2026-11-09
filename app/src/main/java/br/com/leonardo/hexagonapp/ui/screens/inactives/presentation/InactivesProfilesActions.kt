package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.localData.model.PersonalProfile

sealed class InactivesProfilesActions : HexagonAction() {
    class DeleteProfile(
        val profile: PersonalProfile,
    ) : InactivesProfilesActions()

    class ClickProfile(
        val profileId: String,
    ) : InactivesProfilesActions()

    class UpdateProfile(
        val profile: PersonalProfile,
    ) : InactivesProfilesActions()
}
