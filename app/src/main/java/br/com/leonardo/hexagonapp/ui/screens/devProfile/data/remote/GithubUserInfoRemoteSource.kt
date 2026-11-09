package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote

import br.com.leonardo.appcore.data.network.source.RemoteSource
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

/**
 * Remote data source contract for requesting developer profile data from GitHub REST API.
 */
interface GithubUserInfoRemoteSource : RemoteSource {
    /**
     * Requests developer profile information from GitHub API.
     *
     * @return [Result] with [GitHubProfileInfoModel].
     */
    suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel>

    /**
     * Requests public repositories for the developer profile from GitHub API.
     *
     * @return [Result] with list of [GithubRepositoryInfoModel].
     */
    suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>>
}
