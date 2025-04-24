package br.com.leonardo.webClient.source.remote.mapper

import br.com.leonardo.webClient.model.GitHubProfileInfo
import br.com.leonardo.webClient.model.GitHubProfileInfoResponse
import br.com.leonardo.webClient.model.GithubRepositoryInfo
import br.com.leonardo.webClient.model.GithubRepositoryInfoResponse

interface GithubUserInfoMapper {

    fun toModel(githubProfileInfoResponse: GitHubProfileInfoResponse): GitHubProfileInfo

    fun toModel(githubRepositoryInfoResponseList: List<GithubRepositoryInfoResponse>): List<GithubRepositoryInfo>

}