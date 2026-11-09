package br.com.leonardo.hexagonapp.ui.screens.actives.presentation.sections.activesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionView
import br.com.leonardo.hexagonapp.ui.components.PersonalProfileList
import br.com.leonardo.hexagonapp.ui.screens.actives.presentation.ActivesProfilesActions

class ActivesProfilesListSectionView : HexagonSectionView<ActivesProfilesListSectionRender>() {
    @Composable
    override fun Show(
        render: ActivesProfilesListSectionRender,
        onActions: (HexagonAction) -> Unit,
    ) {
        PersonalProfileList(
            list = render.activesProfilesList,
            onCLickItem = { profileId ->
                onActions(ActivesProfilesActions.ClickProfile(profileId))
            },
            onDelete = { profile ->
                onActions(ActivesProfilesActions.DeleteProfile(profile))
            },
            onUpdate = { profile -> onActions(ActivesProfilesActions.UpdateProfile(profile)) },
        )
    }
}
