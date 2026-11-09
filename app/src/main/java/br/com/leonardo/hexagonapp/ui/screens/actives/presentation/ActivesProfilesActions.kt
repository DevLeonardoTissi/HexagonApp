package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.localData.model.PersonalProfile

/** Actions emitted from Active Profiles screen UI. */
sealed class ActivesProfilesActions : HexagonAction() {
    /** Action to delete a personal profile. */
    class DeleteProfile(
        val profile: PersonalProfile,
    ) : ActivesProfilesActions()

    /** Action when a profile card is clicked. */
    class ClickProfile(
        val profileId: String,
    ) : ActivesProfilesActions()

    /** Action to update profile active status. */
    class UpdateProfile(
        val profile: PersonalProfile,
    ) : ActivesProfilesActions()
}
