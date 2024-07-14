package br.com.leonardo.hexagonapp.ui.screens.home

import br.com.leonardo.localData.model.PersonalProfile

data class HomeScreenUiState(
    val activesList: List<PersonalProfile> = emptyList()
)