package br.com.leonardo.hexagonapp.ui.screens.inactives

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.data.data.HexagonData

class InactivesProfilesData(initialState: InactivesProfilesState) :
    HexagonData<InactivesProfilesState>(initialValue = initialState) {

    fun updateProfilesList(profilesList: List<PersonalProfile>) {
        updateState { it.copy(inactiveList = profilesList) }
    }

}