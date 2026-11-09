package br.com.leonardo.hexagonapp.ui.screens.devProfile.presentation

import br.com.leonardo.appcore.presentation.data.data.HexagonData
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

class DevProfileData(
    initialState: DevProfileState,
) : HexagonData<DevProfileState>(initialValue = initialState) {
    fun updateUserProfile(user: GitHubProfileInfoModel) {
        updateState { it.copy(userProfile = user) }
    }

    fun updateUserRepositories(repositories: List<GithubRepositoryInfoModel>) {
        updateState { it.copy(repositories = repositories) }
    }
}
