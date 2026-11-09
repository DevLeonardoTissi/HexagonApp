package br.com.leonardo.hexagonapp.ui.screens.devProfile.data.remote.mapper

import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.data.models.entity.response.GithubRepositoryInfoResponse
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GitHubProfileInfoModel
import br.com.leonardo.hexagonapp.ui.screens.devProfile.domain.model.GithubRepositoryInfoModel

interface GithubUserInfoMapper {
    fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse): GitHubProfileInfoModel

    fun toModel(githubRepositoryInfoListResponse: List<GithubRepositoryInfoResponse>): List<GithubRepositoryInfoModel>
}
