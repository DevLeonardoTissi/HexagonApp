package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import br.com.leonardo.appcore.presentation.data.data.HexagonData
import br.com.leonardo.localData.model.PersonalProfile

/** Data holder for [ActivesProfilesState]. */
class ActivesProfilesData(
    initialState: ActivesProfilesState,
) : HexagonData<ActivesProfilesState>(initialState) {
    /** Updates active profiles list in state. */
    fun updateProfilesList(profilesList: List<PersonalProfile>) {
        updateState { it.copy(activeList = profilesList) }
    }
}
