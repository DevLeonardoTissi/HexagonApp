package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation

import br.com.leonardo.appcore.presentation.data.state.HexagonState
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

data class DevProfileState(
    val userProfile: GitHubProfileInfoModel? = null,
    val repositories: List<GithubRepositoryInfoModel>? = emptyList(),
) : HexagonState
