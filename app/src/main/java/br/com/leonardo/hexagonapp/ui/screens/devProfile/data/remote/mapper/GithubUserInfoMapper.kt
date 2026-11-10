package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GitHubProfileInfoResponseEntity
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.entity.response.GithubRepositoryInfoResponseEntity
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

/**
 * Mapper contract for converting GitHub API DTO responses to domain models.
 */
interface GithubUserInfoMapper {
    /** Maps [GitHubProfileInfoResponseEntity] DTO to [GitHubProfileInfoModel]. */
    fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponseEntity): GitHubProfileInfoModel

    /**
     * Maps list of [GithubRepositoryInfoResponseEntity] DTOs
     * to list of [GithubRepositoryInfoModel].
     */
    fun toModel(
        githubRepositoryInfoListResponse: List<GithubRepositoryInfoResponseEntity>,
    ): List<GithubRepositoryInfoModel>
}
