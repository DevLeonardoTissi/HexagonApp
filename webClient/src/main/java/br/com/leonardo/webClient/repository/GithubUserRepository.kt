package br.com.leonardo.webClient.repository

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo

interface GithubUserRepository {

    suspend fun getUserProfileInfo(): GitHubProfileInfo?

    suspend fun getUserRepositoriesInfo():  List<GithubRepositoryInfo>?
}