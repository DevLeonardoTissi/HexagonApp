package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.localData.model.PersonalProfile

/** Actions emitted from Inactive Profiles screen UI. */
sealed class InactivesProfilesActions : HexagonAction() {
    /** Action to delete an inactive personal profile. */
    class DeleteProfile(
        val profile: PersonalProfile,
    ) : InactivesProfilesActions()

    /** Action when an inactive profile card is clicked. */
    class ClickProfile(
        val profileId: String,
    ) : InactivesProfilesActions()

    /** Action to toggle active status of a profile. */
    class UpdateProfile(
        val profile: PersonalProfile,
    ) : InactivesProfilesActions()
}
