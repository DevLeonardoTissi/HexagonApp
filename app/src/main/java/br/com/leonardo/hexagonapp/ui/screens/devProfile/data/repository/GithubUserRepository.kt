package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.repository

import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

/**
 * Repository contract for retrieving GitHub developer profile and repository information.
 */
interface GithubUserRepository {
    /**
     * Fetches user profile details.
     *
     * @return [Result] containing [GitHubProfileInfoModel] on success.
     */
    suspend fun getUserProfileInfo(): Result<GitHubProfileInfoModel>

    /**
     * Fetches user repositories list.
     *
     * @return [Result] containing list of [GithubRepositoryInfoModel] on success.
     */
    suspend fun getUserRepositoriesInfo(): Result<List<GithubRepositoryInfoModel>>
}
