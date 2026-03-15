package br.com.leonardo.webClient.source.remote.mapper

import br.com.leonardo.webClient.models.model.GitHubProfileInfoModel
import br.com.leonardo.webClient.models.entity.response.GitHubProfileInfoResponse
import br.com.leonardo.webClient.models.model.GithubRepositoryInfoModel
import br.com.leonardo.webClient.models.entity.response.GithubRepositoryInfoResponse

interface GithubUserInfoMapper {

    fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse?): GitHubProfileInfoModel

    fun toModel(githubRepositoryInfoResponse: GithubRepositoryInfoResponse): GithubRepositoryInfoModel

}