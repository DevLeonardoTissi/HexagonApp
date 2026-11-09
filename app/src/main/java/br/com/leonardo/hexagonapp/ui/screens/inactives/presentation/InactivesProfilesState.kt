package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation

import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.localData.model.PersonalProfile

data class InactivesProfilesState(
    val inactiveList: List<PersonalProfile> = emptyList(),
) : HexagonState
