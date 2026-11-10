package br.com.leonardo.hexagonapp.ui.screens.devProfile.mock

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GitHubProfileInfoResponseEntity
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GithubRepositoryInfoResponseEntity
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel
import retrofit2.Response

object Mocks {
    val defaultProfileModel
        get() =
            GitHubProfileInfoModel(
                avatarUrl = "",
                htmlUrl = "",
                name = "",
                blog = "",
                location = "",
                bio = "",
                publicRepos = null,
            )

    val notDefaultProfileModel
        get() =
            GitHubProfileInfoModel(
                avatarUrl = "",
                htmlUrl = "https://github.com/leonardo",
                name = "Leonardo",
                blog = "www.leonardo.com",
                location = "Brasil",
                bio = "Android Developer",
                publicRepos = 10,
            )

    val profileResponse
        get() =
            Response.success(
                GitHubProfileInfoResponseEntity(
                    avatarUrl = "",
                    htmlUrl = "https://github.com/leonardo",
                    name = "Leonardo",
                    blog = "www.leonardo.com",
                    location = "Brasil",
                    bio = "Android Developer",
                    publicRepos = 10,
                ),
            )

    val repositoriesResponseList
        get() =
            Response.success(
                listOf(
                    GithubRepositoryInfoResponseEntity(
                        name = "Repo 1",
                        htmlUrl = "url/1",
                        description = "Desc 1",
                    ),
                    GithubRepositoryInfoResponseEntity(
                        name = "Repo 2",
                        htmlUrl = "url/2",
                        description = "Desc 2",
                    ),
                    GithubRepositoryInfoResponseEntity(
                        name = "Repo 3",
                        htmlUrl = "url/3",
                        description = "Desc 3",
                    ),
                    GithubRepositoryInfoResponseEntity(
                        name = "Repo 4",
                        htmlUrl = "url/4",
                        description = "Desc 4",
                    ),
                ),
            )

    val repositoriesModelList
        get() =
            listOf(
                GithubRepositoryInfoModel(
                    name = "Repo 1",
                    htmlUrl = "url/1",
                    description = "Desc 1",
                ),
                GithubRepositoryInfoModel(
                    name = "Repo 2",
                    htmlUrl = "url/2",
                    description = "Desc 2",
                ),
                GithubRepositoryInfoModel(
                    name = "Repo 3",
                    htmlUrl = "url/3",
                    description = "Desc 3",
                ),
                GithubRepositoryInfoModel(
                    name = "Repo 4",
                    htmlUrl = "url/4",
                    description = "Desc 4",
                ),
            )
}
