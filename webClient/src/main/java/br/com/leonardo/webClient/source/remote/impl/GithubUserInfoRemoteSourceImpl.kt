package br.com.leonardo.webClient.source.remote.impl

import br.com.leonardo.webClient.R
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.services.GithubApiService
import br.com.leonardo.webClient.source.remote.GithubUserInfoRemoteSource
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.webClient.utils.buildURLPath.buildPath

class GithubUserInfoRemoteSourceImpl(
    private val githubProfileService: GithubApiService,
    private val mapper: GithubUserInfoMapper
) : GithubUserInfoRemoteSource {

    override suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel> =
        requestNotNullable(
            call = {
                githubProfileService.getUserProfileInfo(
                    path = buildPath(
                        urlID = R.string.dev_leonardo_tissi_url,
                        params = listOf(userParam to "devleonardotissi")
                    )
                )
            }, onSuccess = { _, response ->
                mapper.toModel(githubProfileInfoResponse = response)
            })


    override suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>> =
        requestNotNullable(
            call = {
                githubProfileService.getUserRepositoriesInfo(
                    path = buildPath(
                        urlID = R.string.dev_leonardo_tissi_repos,
                        params = listOf(userParam to "devleonardotissi")
                    ),
                    sort = sortCreated,
                    direction = directionDesc
                )
            }, onSuccess = { _, response ->
                mapper.toModel(githubRepositoryInfoListResponse = response)
            })

}

private const val userParam = "user"
private const val sortCreated = "created"
private const val directionDesc = "desc"