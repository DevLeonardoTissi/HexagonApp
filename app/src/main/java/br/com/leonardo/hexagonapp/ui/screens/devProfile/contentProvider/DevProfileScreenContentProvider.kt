package br.com.leonardo.hexagonapp.ui.screens.devProfile.contentProvider

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error.ErrorSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.loading.LoadSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories.RepositoriesSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.user.UserSection
import br.com.leonardo.hexagonapp.utils.DevProfileScreenState
import br.com.leonardo.ui.content.layout.content.HexagonContent
import br.com.leonardo.ui.content.provider.HexagonContentProvider

class DevProfileScreenContentProvider : HexagonContentProvider<DevProfileState, DevProfileUIState> {

    override fun getContent(
        state: DevProfileState,
        uiState: DevProfileUIState
    ): List<HexagonContent> {
        return when (uiState.screenState) {
            is DevProfileScreenState.Loading -> getLoadingSections()
            is DevProfileScreenState.Success -> getSuccessSections()
            is DevProfileScreenState.Error -> getErrorSections()
        }
    }

    fun getSuccessSections(): List<HexagonContent> = listOf(UserSection(), RepositoriesSection())

    fun getLoadingSections(): List<HexagonContent> = listOf(LoadSection())

    fun getErrorSections(): List<HexagonContent> = listOf(ErrorSection())

}