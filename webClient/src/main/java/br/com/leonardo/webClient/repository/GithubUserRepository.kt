package br.com.leonardo.webClient.repository

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

interface GithubUserRepository {

    suspend fun getUserProfileInfo(): GitHubProfileInfoModel

    suspend fun getUserRepositoriesInfo():  List<GithubRepositoryInfoModel>
}