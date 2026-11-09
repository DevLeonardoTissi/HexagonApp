package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import br.com.leonardo.appcore.presentation.data.data.HexagonData
import br.com.leonardo.localData.model.PersonalProfile

/** Data holder for [InactivesProfilesState]. */
class InactivesProfilesData(
    initialState: InactivesProfilesState,
) : HexagonData<InactivesProfilesState>(initialValue = initialState) {
    /** Updates inactive profiles list in state. */
    fun updateProfilesList(profilesList: List<PersonalProfile>) {
        updateState { it.copy(inactiveList = profilesList) }
    }
}
