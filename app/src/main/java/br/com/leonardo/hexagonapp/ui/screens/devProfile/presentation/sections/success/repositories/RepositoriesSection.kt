package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.repositories

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSection
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.DevProfileUIState

class RepositoriesSection :
    HexagonSection<DevProfileState, DevProfileUIState, RepositoriesSectionRender>(
        view = RepositoriesSectionView(),
        mapper = RepositoriesSectionMapper(),
    )
