package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.response.GitHubProfileInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.response.GithubRepositoryInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

/**
 * Mapper contract for converting GitHub API DTO responses to domain models.
 */
interface GithubUserInfoMapper {
    /** Maps [GitHubProfileInfoResponse] DTO to [GitHubProfileInfoModel]. */
    fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse): GitHubProfileInfoModel

    /** Maps list of [GithubRepositoryInfoResponse] DTOs to list of [GithubRepositoryInfoModel]. */
    fun toModel(githubRepositoryInfoListResponse: List<GithubRepositoryInfoResponse>): List<GithubRepositoryInfoModel>
}
