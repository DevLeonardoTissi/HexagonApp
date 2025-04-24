package br.com.leonardo.webClient.source

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo

interface GithubUserInfoSource {

    suspend fun getUserProfileInfo(): GitHubProfileInfo?

    suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfo>?

}