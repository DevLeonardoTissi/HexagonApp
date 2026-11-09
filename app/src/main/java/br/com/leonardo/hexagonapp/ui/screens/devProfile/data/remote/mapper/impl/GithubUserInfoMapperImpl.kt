package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper.impl

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.models.entity.response.GithubRepositoryInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper.GithubUserInfoMapper
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

class GithubUserInfoMapperImpl : GithubUserInfoMapper {
    override fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse): GitHubProfileInfoModel =
        with(githubProfileInfoResponse) {
            GitHubProfileInfoModel(
                avatarUrl = avatarUrl.orEmpty(),
                htmlUrl = htmlUrl.orEmpty(),
                name = name.orEmpty(),
                blog = blog.orEmpty(),
                location = location.orEmpty(),
                bio = bio.orEmpty(),
                publicRepos = publicRepos,
            )
        }

    override fun toModel(
        githubRepositoryInfoListResponse: List<GithubRepositoryInfoResponse>,
    ): List<GithubRepositoryInfoModel> =
        githubRepositoryInfoListResponse.map {
            GithubRepositoryInfoModel(
                name = it.name.orEmpty(),
                htmlUrl = it.htmlUrl.orEmpty(),
                description = it.description.orEmpty(),
            )
        }
}
