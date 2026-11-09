package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.impl

import br.com.leonardo.appcore.data.network.utils.buildURLPath.buildPath
import br.com.leonardo.hexagonapp.R
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.GithubUserInfoRemoteSource
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.services.GithubApiService
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

class GithubUserInfoRemoteSourceImpl(
    private val githubProfileService: GithubApiService,
    private val mapper: GithubUserInfoMapper,
) : GithubUserInfoRemoteSource {
    override suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel> =
        requestNotNullable(
            call = {
                githubProfileService.getUserProfileInfo(
                    path =
                        buildPath(
                            urlID = R.string.dev_leonardo_tissi_url,
                            params = listOf(userParam to "devleonardotissi"),
                        ),
                )
            },
            onSuccess = { _, response ->
                mapper.toModel(githubProfileInfoResponse = response)
            },
        )

    override suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>> =
        requestNotNullable(
            call = {
                githubProfileService.getUserRepositoriesInfo(
                    path =
                        buildPath(
                            urlID = R.string.dev_leonardo_tissi_repos,
                            params = listOf(userParam to "devleonardotissi"),
                        ),
                    sort = sortCreated,
                    direction = directionDesc,
                )
            },
            onSuccess = { _, response ->
                mapper.toModel(githubRepositoryInfoListResponse = response)
            },
        )
}

private const val userParam = "user"
private const val sortCreated = "created"
private const val directionDesc = "desc"
