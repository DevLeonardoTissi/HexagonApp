package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.ui.data.state.HexagonState
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

data class DevProfileState(
    val userProfile: GitHubProfileInfoModel? = null,
    val repositories: List<GithubRepositoryInfoModel>? = emptyList(),
) : HexagonState