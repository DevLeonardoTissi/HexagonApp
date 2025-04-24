package br.com.leonardo.webClient.source.remote

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo

interface GithubUserInfoRemoteSource {

    suspend fun getUserProfileInfo(): GitHubProfileInfo?

    suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfo>?

}