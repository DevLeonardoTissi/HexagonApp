package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.hexagonapp.utils.DevUiProfileState

data class DevProfileUiState(
    val userProfile: GitHubProfileInfoModel? = GitHubProfileInfoModel(),
    val state: DevUiProfileState = DevUiProfileState.Loading,
    val repositories: List<GithubRepositoryInfoModel>? = emptyList(),
    val onLoadUserInfo: () -> Unit = {},
    val refreshing: Boolean = false,
    val refreshingPerform: () -> Unit = {},
    val showBottomSheetShareProfile: Boolean = false,
    val changeVisibilityBottomSheetShareProfile: (Boolean) -> Unit = {}
)
