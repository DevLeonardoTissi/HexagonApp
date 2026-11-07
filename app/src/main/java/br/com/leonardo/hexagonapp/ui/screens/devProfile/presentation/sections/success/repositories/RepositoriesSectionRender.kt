package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.success.repositories

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

data class RepositoriesSectionRender(
    val title: String,
    val repositoriesList: List<GithubRepositoryInfoModel>? = emptyList(),
    val showBottomSheetShareProfile: Boolean,
) : HexagonSectionRender
