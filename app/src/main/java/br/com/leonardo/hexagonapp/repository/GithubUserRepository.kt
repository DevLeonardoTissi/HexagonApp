package br.com.leonardo.hexagonapp.repository

import br.com.leonardo.hexagonapp.model.GitHubProfileInfo
import br.com.leonardo.hexagonapp.webClient.model.GithubRepositoryInfoResponse
import br.com.leonardo.hexagonapp.webClient.services.GithubApiService

class GithubUserRepository(private val githubProfileService: GithubApiService) {

    suspend fun getUserProfileInfo(): GitHubProfileInfo {
        return githubProfileService.getUserProfileInfo().gitHubProfileInfo
    }

    suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfoResponse> {
        return githubProfileService.getUserRepositoriesInfo()
    }
}