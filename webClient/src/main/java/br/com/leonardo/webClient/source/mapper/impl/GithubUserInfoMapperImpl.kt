package br.com.leonardo.webClient.source.mapper.impl

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GitHubProfileInfoResponse
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfoResponse
import br.com.leonardo.webClient.source.mapper.GithubUserInfoMapper

class GithubUserInfoMapperImpl : GithubUserInfoMapper {
    override fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse): GitHubProfileInfo {
        with(githubProfileInfoResponse) {
            return GitHubProfileInfo(
                avatar_url = avatarUrl,
                html_url = htmlUrl,
                name = name,
                blog = blog,
                location = location,
                bio = bio,
                public_repos = publicRepos
            )
        }
    }

    override fun toModel(githubRepositoryInfoResponseList: List<GithubRepositoryInfoResponse>): List<GithubRepositoryInfo> {
        return githubRepositoryInfoResponseList.map { responseItem ->
            GithubRepositoryInfo(
                name = responseItem.name,
                html_url = responseItem.htmlUrl,
                description = responseItem.description
            )
        }
    }
}