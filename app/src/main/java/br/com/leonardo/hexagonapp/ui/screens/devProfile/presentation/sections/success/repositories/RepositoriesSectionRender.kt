package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation.sections.success.repositories

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

data class RepositoriesSectionRender(
    val title: String,
    val repositoriesList: List<GithubRepositoryInfoModel>? = emptyList(),
    val showBottomSheetShareProfile: Boolean,
) : HexagonSectionRender
