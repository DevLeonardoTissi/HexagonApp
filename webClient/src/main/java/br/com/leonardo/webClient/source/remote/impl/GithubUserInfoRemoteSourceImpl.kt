package br.com.leonardo.webClient.source.remote.impl

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper

class GithubUserInfoRemoteSourceImpl(
    private val githubProfileService: GithubApiService,
    private val mapper: GithubUserInfoMapper
) : GithubUserInfoRemoteSource {

    override suspend fun getUserProfileInfo(): GitHubProfileInfoModel =
        mapper.toModel(githubProfileInfoResponse = githubProfileService.getUserProfileInfo())


    override suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfoModel> =
        githubProfileService.getUserRepositoriesInfo()?.let {
            it.map { responseItem -> mapper.toModel(githubRepositoryInfoResponse = responseItem) }
        } ?: emptyList()
}