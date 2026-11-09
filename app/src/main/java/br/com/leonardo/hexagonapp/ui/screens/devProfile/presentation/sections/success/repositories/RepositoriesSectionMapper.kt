package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.repositories

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionMapper
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class RepositoriesSectionMapper :
    HexagonSectionMapper<DevProfileState, DevProfileUIState, RepositoriesSectionRender> {
    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState,
    ): RepositoriesSectionRender {
        val title = stringResource(R.string.repositoriesTitle)
        val repositories = state.repositories

        return RepositoriesSectionRender(
            title = title,
            repositoriesList = repositories,
            showBottomSheetShareProfile = uiState.showBottomSheetShareProfile,
        )
    }
}
