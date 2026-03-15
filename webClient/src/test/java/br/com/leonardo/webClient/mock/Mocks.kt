package br.com.leonardo.webClient.mock

import br.com.leonardo.webClient.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.webClient.models.entity.response.GithubRepositoryInfoResponse
import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel

object Mocks {
    val defaultProfileModel
        get() = GitHubProfileInfoModel(
            avatarUrl = "",
            htmlUrl = "",
            name = "",
            blog = "",
            location = "",
            bio = "",
            publicRepos = null
        )

    val notDefaultProfileModel
        get() = GitHubProfileInfoModel(
            avatarUrl = "",
            htmlUrl = "https://github.com/leonardo",
            name = "Leonardo",
            blog = "www.leonardo.com",
            location = "Brasil",
            bio = "Android Developer",
            publicRepos = 10
        )

    val profileResponse
        get() = GitHubProfileInfoResponse(
            avatarUrl = "",
            htmlUrl = "https://github.com/leonardo",
            name = "Leonardo",
            blog = "www.leonardo.com",
            location = "Brasil",
            bio = "Android Developer",
            publicRepos = 10
        )

    val repositoriesResponseList
        get() = listOf(
            GithubRepositoryInfoResponse(
                name = "Repo 1",
                htmlUrl = "url/1",
                description = "Desc 1"
            ),
            GithubRepositoryInfoResponse(
                name = "Repo 2",
                htmlUrl = "url/2",
                description = "Desc 2"
            ),
            GithubRepositoryInfoResponse(
                name = "Repo 3",
                htmlUrl = "url/3",
                description = "Desc 3"
            ),
            GithubRepositoryInfoResponse(
                name = "Repo 4",
                htmlUrl = "url/4",
                description = "Desc 4"
            )
        )

    val repositoriesModelList
        get() = listOf(
            GithubRepositoryInfoModel(
                name = "Repo 1",
                htmlUrl = "url/1",
                description = "Desc 1"
            ),
            GithubRepositoryInfoModel(
                name = "Repo 2",
                htmlUrl = "url/2",
                description = "Desc 2"
            ),
            GithubRepositoryInfoModel(
                name = "Repo 3",
                htmlUrl = "url/3",
                description = "Desc 3"
            ),
            GithubRepositoryInfoModel(
                name = "Repo 4",
                htmlUrl = "url/4",
                description = "Desc 4"
            )
        )

}