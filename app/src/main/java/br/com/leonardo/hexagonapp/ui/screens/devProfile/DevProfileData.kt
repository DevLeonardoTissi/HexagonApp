package br.com.leonardo.hexagonapp.ui.screens.devProfile

import br.com.leonardo.hexagonapp.ui.screens.utils.HexagonData
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

class DevProfileData(initialState: DevProfileState) :
    HexagonData<DevProfileState>(initialValue = initialState) {

    fun updateUserProfile(user: GitHubProfileInfoModel){
        updateState { it.copy(userProfile = user) }
    }

    fun updateUserRepositories(repositories: List<GithubRepositoryInfoModel>){
        updateState { it.copy(repositories = repositories) }
    }
}