package br.com.leonardo.webClient.source.remote.impl

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper

class GithubUserInfoRemoteSourceImpl(
    private val githubProfileService: GithubApiService,
    private val mapper: GithubUserInfoMapper
) : GithubUserInfoRemoteSource {

    override suspend fun getUserProfileInfo(): GitHubProfileInfo? {
        return githubProfileService.getUserProfileInfo()?.let {
            mapper.toModel(it)
        }
    }

    override suspend fun getUserRepositoriesInfo(): List<GithubRepositoryInfo>? {
        return githubProfileService.getUserRepositoriesInfo()?.let {
            mapper.toModel(it)
        }
    }

}