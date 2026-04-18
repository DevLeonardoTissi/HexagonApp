package br.com.leonardo.hexagonapp.ui.screens.actives

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.data.state.HexagonState

data class ActivesProfilesState(
    val inactiveList: List<PersonalProfile> = emptyList()
): HexagonState