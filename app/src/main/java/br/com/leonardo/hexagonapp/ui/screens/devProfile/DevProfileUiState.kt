package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.hexagonapp.utils.DevUiProfileState

data class DevProfileUiState(
    val userProfile: GitHubProfileInfo? = GitHubProfileInfo(),
    val state: DevUiProfileState = DevUiProfileState.Loading,
    val repositories: List<GithubRepositoryInfo>? = emptyList(),
    val onLoadUserInfo: () -> Unit = {}
)
