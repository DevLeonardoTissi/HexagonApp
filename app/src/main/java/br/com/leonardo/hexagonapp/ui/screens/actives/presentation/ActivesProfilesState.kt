package br.com.leonardo.hexagonapp.ui.screens.actives.presentation

import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.localData.model.PersonalProfile

/** Data state for Active Profiles screen holding observed profiles list. */
data class ActivesProfilesState(
    val activeList: List<PersonalProfile> = emptyList(),
) : HexagonState
