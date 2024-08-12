package br.com.leonardo.webClient.repository

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.services.GithubApiService

class GithubUserRepositoryImpl(private val githubProfileService: GithubApiService) : GithubUserRepository {

    override suspend fun getUserProfileInfo(): GitHubProfileInfo? {
        return githubProfileService.getUserProfileInfo()?.gitHubProfileInfo
    }

    override suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfo>? {
        return githubProfileService.getUserRepositoriesInfo()?.map { repositoryInfoResponse ->
            repositoryInfoResponse.gitHubRepositoryInfo
        }
    }
}