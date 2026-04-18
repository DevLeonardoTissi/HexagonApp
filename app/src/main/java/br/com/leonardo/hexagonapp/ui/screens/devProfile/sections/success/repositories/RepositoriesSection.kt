package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories

import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.DevProfileUIState
import br.com.leonardo.ui.content.layout.section.HexagonSection

class RepositoriesSection : HexagonSection<DevProfileState, DevProfileUIState, RepositoriesSectionRender>(
    view = RepositoriesSectionView(),
    mapper = RepositoriesSectionMapper()
)