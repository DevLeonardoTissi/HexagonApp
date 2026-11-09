package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import br.com.leonardo.appcore.presentation.data.data.HexagonData
import br.com.leonardo.localData.model.PersonalProfile

class InactivesProfilesData(
    initialState: InactivesProfilesState,
) : HexagonData<InactivesProfilesState>(initialValue = initialState) {
    fun updateProfilesList(profilesList: List<PersonalProfile>) {
        updateState { it.copy(inactiveList = profilesList) }
    }
}
