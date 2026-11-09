package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.localData.model.PersonalProfile

data class ActivesProfilesState(
    val activeList: List<PersonalProfile> = emptyList(),
) : HexagonState
