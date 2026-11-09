package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository

import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

interface GithubUserRepository {
    suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel>

    suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>>
}
