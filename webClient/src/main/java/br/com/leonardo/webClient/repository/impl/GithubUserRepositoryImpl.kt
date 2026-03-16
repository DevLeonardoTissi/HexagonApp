package br.com.leonardo.webClient.repository.impl

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource

class GithubUserRepositoryImpl(
    private val githubUserInfoRemoteSource: GithubUserInfoRemoteSource
) : GithubUserRepository {

    override suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel> {
        return githubUserInfoRemoteSource.getUserProfileInfo()
    }

    override suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>> {
        return githubUserInfoRemoteSource.getUserRepositoriesInfo()

    }
}