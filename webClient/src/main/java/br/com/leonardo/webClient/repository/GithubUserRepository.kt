package br.com.leonardo.webClient.repository

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

interface GithubUserRepository {

    suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel>

    suspend fun getUserRepositoriesInfo():  Result<List<GithubRepositoryInfoModel>>
}