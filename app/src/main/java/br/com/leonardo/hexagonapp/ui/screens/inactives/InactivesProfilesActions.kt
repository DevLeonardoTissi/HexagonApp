package br.com.leonardo.hexagonapp.ui.screens.inactives

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.action.HexagonAction

sealed class InactivesProfilesActions : HexagonAction() {
    class DeleteProfile(val profile: PersonalProfile) : InactivesProfilesActions()
    class ClickProfile(val profileId: String) : InactivesProfilesActions()
    class UpdateProfile(val profile: PersonalProfile) : InactivesProfilesActions()
}