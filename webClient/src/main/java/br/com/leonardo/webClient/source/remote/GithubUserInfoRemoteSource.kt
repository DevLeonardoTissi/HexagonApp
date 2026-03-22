package br.com.leonardo.webClient.source.remote

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

interface GithubUserInfoRemoteSource : RemoteSource {

    suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel>

    suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>>

}