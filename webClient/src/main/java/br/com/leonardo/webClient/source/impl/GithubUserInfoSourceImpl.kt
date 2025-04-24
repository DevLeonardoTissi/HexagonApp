package br.com.leonardo.webClient.source.impl

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.GithubUserInfoSource
import br.com.leonardo.webClient.source.mapper.GithubUserInfoMapper

class GithubUserInfoSourceImpl(
    private val githubProfileService: GithubApiService,
    private val mapper: GithubUserInfoMapper
) : GithubUserInfoSource {

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