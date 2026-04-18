package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.user

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class UserSectionMapper :
    HexagonSectionMapper<DevProfileState, DevProfileUIState, UserSectionRender> {
    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState
    ): UserSectionRender {
        val userInfo = state.userProfile
        val userImageDescription = stringResource(R.string.devProfileImageDescription)
        val shareIconDescription = stringResource(R.string.shareProfileIconDescription)
        return UserSectionRender(
            userProfile = userInfo,
            userImageDescription = userImageDescription,
            shareIconDescription = shareIconDescription
        )
    }
}