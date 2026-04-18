package br.com.leonardo.hexagonapp.ui.screens.actives.sections.activesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.hexagonapp.ui.components.PersonalProfileList
import br.com.leonardo.hexagonapp.ui.screens.actives.ActivesProfilesActions
import br.com.leonardo.ui.action.HexagonAction
import br.com.leonardo.ui.content.layout.section.HexagonSectionView

class ActivesProfilesListSectionView : HexagonSectionView<ActivesProfilesListSectionRender>() {

    @Composable
    override fun Show(
        render: ActivesProfilesListSectionRender,
        onActions: (HexagonAction) -> Unit
    ) {
        PersonalProfileList(
            list = render.activesProfilesList,
            onCLickItem = { profileId ->
                // onClickItem(profileId)
            }, onDelete = { profile ->
                onActions(ActivesProfilesActions.DeleteProfile(profile))
            }, onUpdate = { profile -> onActions(ActivesProfilesActions.UpdateProfile(profile)) }
        )
    }
}