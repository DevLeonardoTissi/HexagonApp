package br.com.leonardo.hexagonapp.ui.screens.inactive

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.model.PersonalProfile
import br.com.leonardo.hexagonapp.ui.components.PersonalProfileList

@Composable
fun InactiveScreen(
    uiState: InactiveProfilesUiState,
    onClickItem: (profileId: String) -> Unit,
    onDelete: (profile: PersonalProfile) -> Unit
) {

    PersonalProfileList(list = uiState.inactiveList, onCLickItem = { profileId ->
        onClickItem(profileId)
    }, onDelete = { profile ->
        onDelete(profile)
    })
}