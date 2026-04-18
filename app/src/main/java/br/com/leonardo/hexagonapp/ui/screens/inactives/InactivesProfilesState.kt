package br.com.leonardo.hexagonapp.ui.screens.inactives

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.ui.data.state.HexagonState

data class InactivesProfilesState(
    val inactiveList: List<PersonalProfile> = emptyList()
) : HexagonState
