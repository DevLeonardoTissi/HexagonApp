package br.com.leonardo.hexagonapp.repository

import br.com.leonardo.hexagonapp.model.GitHubProfileInfo
import br.com.leonardo.hexagonapp.model.GithubRepositoryInfo
import br.com.leonardo.hexagonapp.webClient.services.GithubApiService

class GithubUserRepository(private val githubProfileService: GithubApiService) {

    suspend fun getUserProfileInfo(): GitHubProfileInfo? {
        return githubProfileService.getUserProfileInfo()?.gitHubProfileInfo
    }

    suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfo>? {
        return githubProfileService.getUserRepositoriesInfo()?.map { repositoryInfoResponse ->
            repositoryInfoResponse.gitHubRepositoryInfo
        }
    }
}