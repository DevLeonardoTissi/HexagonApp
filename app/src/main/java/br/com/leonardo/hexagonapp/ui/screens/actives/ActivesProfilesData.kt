package br.com.leonardo.hexagonapp.ui.screens.actives

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.data.data.HexagonData

class ActivesProfilesData(initialState: ActivesProfilesState) :
    HexagonData<ActivesProfilesState>(initialState) {

    fun updateProfilesList(profilesList: List<PersonalProfile>) {
        updateState { it.copy(activeList = profilesList) }
    }
}