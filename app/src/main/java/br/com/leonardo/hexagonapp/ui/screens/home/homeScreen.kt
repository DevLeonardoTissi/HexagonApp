package br.com.leonardo.hexagonapp.ui.screens.home

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.ui.components.PersonalProfileList

@Composable
fun HomeScreen(
    uiState: HomeScreenUiState,
    onClickItem: (profileId: String) -> Unit,
    onDelete: (profile: PersonalProfile) -> Unit
) {

    PersonalProfileList(list = uiState.activesList, onCLickItem = { profileId ->
        onClickItem(profileId)
    }, onDelete = { profile ->
        onDelete(profile)
    })
}