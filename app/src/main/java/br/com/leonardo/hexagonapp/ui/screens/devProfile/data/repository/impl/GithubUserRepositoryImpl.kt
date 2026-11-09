package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository.impl

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.GithubUserInfoRemoteSource
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository.GithubUserRepository
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

class GithubUserRepositoryImpl(
    private val githubUserInfoRemoteSource: GithubUserInfoRemoteSource,
) : GithubUserRepository {
    override suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel> =
        githubUserInfoRemoteSource.getUserProfileInfo()

    override suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>> =
        githubUserInfoRemoteSource.getUserRepositoriesInfo()
}
