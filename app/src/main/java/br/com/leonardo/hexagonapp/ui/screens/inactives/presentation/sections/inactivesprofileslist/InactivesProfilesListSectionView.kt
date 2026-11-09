package br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.sections.inactivesprofileslist

import androidx.compose.runtime.Composable
import br.com.leonardo.appcore.presentation.action.HexagonAction
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionView
import br.com.leonardo.hexagonapp.ui.components.PersonalProfileList
import br.com.leonardo.hexagonapp.ui.screens.inactives.presentation.InactivesProfilesActions

class InactivesProfilesListSectionView : HexagonSectionView<InactivesProfilesListSectionRender>() {
    @Composable
    override fun Show(
        render: InactivesProfilesListSectionRender,
        onActions: (HexagonAction) -> Unit,
    ) {
        PersonalProfileList(
            list = render.inactivesProfilesList,
            onCLickItem = { profileId ->
                onActions(InactivesProfilesActions.ClickProfile(profileId))
            },
            onDelete = { profile ->
                onActions(InactivesProfilesActions.DeleteProfile(profile))
            },
            onUpdate = { profile -> onActions(InactivesProfilesActions.UpdateProfile(profile)) },
        )
    }
}
