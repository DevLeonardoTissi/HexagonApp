package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSectionMapper

class RepositoriesSectionMapper :
    HexagonSectionMapper<DevProfileState, DevProfileUIState, RepositoriesSectionRender> {

    @Composable
    override fun map(
        state: DevProfileState,
        uiState: DevProfileUIState
    ): RepositoriesSectionRender {

        val title = stringResource(R.string.repositoriesTitle)
        val repositories = state.repositories

        return RepositoriesSectionRender(title = title, repositoriesList = repositories, showBottomSheetShareProfile =  uiState.showBottomSheetShareProfile)
    }

}