package br.com.leonardo.webClient.source.remote.mapper.impl

import br.com.leonardo.webClient.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.webClient.models.entity.response.GithubRepositoryInfoResponse
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.source.remote.mapper.GithubUserInfoMapper

class GithubUserInfoMapperImpl : GithubUserInfoMapper {
    override fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse?): GitHubProfileInfoModel =
        with(githubProfileInfoResponse) {
            GitHubProfileInfoModel(
                avatarUrl = this?.avatarUrl.orEmpty(),
                htmlUrl = this?.htmlUrl.orEmpty(),
                name = this?.name.orEmpty(),
                blog = this?.blog.orEmpty(),
                location = this?.location.orEmpty(),
                bio = this?.bio.orEmpty(),
                publicRepos = this?.publicRepos
            )
        }

    override fun toModel(githubRepositoryInfoResponse: GithubRepositoryInfoResponse): GithubRepositoryInfoModel =
        with(githubRepositoryInfoResponse) {
            GithubRepositoryInfoModel(
                name = name.orEmpty(),
                htmlUrl = htmlUrl.orEmpty(),
                description = description.orEmpty()
            )
        }
}