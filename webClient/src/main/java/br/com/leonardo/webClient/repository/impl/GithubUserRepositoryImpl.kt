package br.com.leonardo.webClient.repository.impl

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource

class GithubUserRepositoryImpl(
    private val githubUserInfoSource: GithubUserInfoRemoteSource
) : GithubUserRepository {

    override suspend fun getUserProfileInfo(): GitHubProfileInfoModel {
        return githubUserInfoSource.getUserProfileInfo()
    }

    override suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfoModel> {
        return githubUserInfoSource.getUserRepositoriesInfo()

    }
}