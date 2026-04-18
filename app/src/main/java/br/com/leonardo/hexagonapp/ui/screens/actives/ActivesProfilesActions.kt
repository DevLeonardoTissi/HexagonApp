package br.com.leonardo.hexagonapp.ui.screens.actives

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.action.HexagonAction

sealed class ActivesProfilesActions : HexagonAction() {
    class DeleteProfile(val profile: PersonalProfile) : ActivesProfilesActions()
    class ClickProfile(val profileId: String) : ActivesProfilesActions()
    class UpdateProfile(val profile: PersonalProfile) : ActivesProfilesActions()
}