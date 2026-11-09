package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.localData.model.PersonalProfile

sealed class ActivesProfilesActions : HexagonAction() {
    class DeleteProfile(
        val profile: PersonalProfile,
    ) : ActivesProfilesActions()

    class ClickProfile(
        val profileId: String,
    ) : ActivesProfilesActions()

    class UpdateProfile(
        val profile: PersonalProfile,
    ) : ActivesProfilesActions()
}
