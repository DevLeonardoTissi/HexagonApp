package br.com.leonardo.webClient.repository.impl

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.repository.GithubUserRepository
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource

class GithubUserRepositoryImpl(
    private val githubUserInfoSource: GithubUserInfoRemoteSource
) : GithubUserRepository {

    override suspend fun getUserProfileInfo(): GitHubProfileInfo? {
        return githubUserInfoSource.getUserProfileInfo()
    }

    override suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfo>? {
        return githubUserInfoSource.getUserRepositoriesInfo()

    }
}