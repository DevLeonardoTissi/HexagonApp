package br.com.leonardo.webClient.source.remote

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

interface GithubUserInfoRemoteSource {

    suspend fun getUserProfileInfo(): GitHubProfileInfoModel

    suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfoModel>

}