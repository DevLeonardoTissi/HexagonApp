package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.contentProvider

import br.com.leonardo.appcore.presentation.content.layout.content.HexagonContent
import br.com.leonardo.appcore.presentation.content.provider.HexagonContentProvider
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.model.DevProfileScreenState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.error.ErrorSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.loading.LoadSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.repositories.RepositoriesSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.user.UserSection

class DevProfileScreenContentProvider : HexagonContentProvider<DevProfileState, DevProfileUIState> {
    override fun getContent(
        state: DevProfileState,
        uiState: DevProfileUIState,
    ): List<HexagonContent> =
        when (uiState.screenState) {
            is DevProfileScreenState.Loading -> getLoadingSections()
            is DevProfileScreenState.Success -> getSuccessSections()
            is DevProfileScreenState.Error -> getErrorSections()
        }

    fun getSuccessSections(): List<HexagonContent> = listOf(UserSection(), RepositoriesSection())

    fun getLoadingSections(): List<HexagonContent> = listOf(LoadSection())

    fun getErrorSections(): List<HexagonContent> = listOf(ErrorSection())
}
